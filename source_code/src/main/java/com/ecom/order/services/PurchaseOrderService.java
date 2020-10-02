package com.ecom.order.services;

import com.ecom.order.dalc.entities.*;
import com.ecom.order.dalc.repositories.IPurchaseOrderRepository;
import com.ecom.order.tools.CurrencyCLP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderService {

    @Autowired private IPurchaseOrderRepository purchaseOrderRepository;
    @Autowired private PurchaseOrderSummaryService purchaseOrderSummaryService;
    @Autowired private PurchaseOrderStatusService purchaseOrderStatusService;
    @Autowired private PaymentStatusService paymentStatusService;
    @Autowired private CouponService couponService;
    @Autowired private CurrencyCLP currencyCLP;

    public BuyOrder save(PurchaseOrder entity){
        entity.setIdPurchaseOrder(null);
        entity.setCreated(new Date());
        entity.setModified(null);
        entity.setPurchaseOrderSummary(purchaseOrderSummaryService.save(this.calculateSummary(entity)));
        entity.setPurchaseOrderStatus(purchaseOrderStatusService.findByCode("PP"));
        entity.setPaymentStatus(paymentStatusService.findByResponseCode("PP"));
        entity.setIdSession("mi-id-de-sesion"); // MOCK

        for (Product product : entity.getProducts()){
            product.setMsProductIdProduct(product.getIdProduct());
            product.setIdProduct(null);
            product.setPurchaseOrder(entity);
            product.getVariant().setIdVariant(null);
            for (Option option : product.getVariant().getOptions()){
                option.setIdOption(null);
                option.setVariant(product.getVariant());
            }
        }

        entity = purchaseOrderRepository.save(entity);
        return new BuyOrder(entity.getPurchaseOrderSummary().getTotal(), entity.getIdSession(), entity.getIdPurchaseOrder().toString());
    }


    public PurchaseOrder findById(@NotNull Long id){
        Optional<PurchaseOrder> entity = purchaseOrderRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public List<PurchaseOrder> findAll(){
        return purchaseOrderRepository.findAll();
    }

    public void update(@NotNull PurchaseOrder entity){
        entity.setProducts(null);
        entity.setModified(new Date());
        purchaseOrderRepository.save(entity);
    }

    public String updatePaymentTransaction(ResultTransactionMessage result){
        PurchaseOrder order = this.findById(Long.parseLong(result.getBuyOrder()));
        PaymentStatus payStatus = paymentStatusService.findByResponseCodeAndPaymentMethod(result.getResponseCode(), result.getPaymentModuleCode());
        PurchaseOrderStatus orderStatus = null;
        if(order != null){
            if(payStatus != null){
                order.setPaymentStatus(payStatus);
                if(payStatus.isPaid()){
                    orderStatus = purchaseOrderStatusService.findByCode("AP");
                    if(orderStatus != null){
                        order.setPurchaseOrderStatus(orderStatus);
                    }
                }
            }
            else{
                payStatus = paymentStatusService.findByResponseCode("NS");
                if(payStatus != null){
                    order.setPaymentStatus(payStatus);
                }
            }
            order.setIdTransaction(result.getIdTransaction());
            order.setTransactionDate(result.getTransactionDate());
            this.update(order);
            return order.getIdPurchaseOrder().toString();
        }
        return "0";
    }

    public List<PurchaseOrder> findAllByStatus(Long idPurchaseOrderStatus){
        return purchaseOrderRepository.findAllByStatus(idPurchaseOrderStatus);
    }

    public PurchaseOrderSummary calculateSummary(PurchaseOrder order){
        PurchaseOrderSummary summary = new PurchaseOrderSummary();
        summary.setSubTotal(new BigDecimal(0));
        summary.setTaxTotal(new BigDecimal(0));
        summary.setShipmentCost(new BigDecimal(0));
        summary.setDiscountTotal(new BigDecimal(0));
        summary.setTotal(new BigDecimal(0));

        // products
        for (Product product : order.getProducts()){
            summary.setSubTotal(summary.getSubTotal().add(product.getCurrentTotalPrice().multiply(new BigDecimal(product.getQuantity()))));
            //TODO: add logic for products on sale
        }

        // taxes
        if(order.getTaxes() != null){
            for (Tax tax : order.getTaxes()){
                if(tax.getPercentage() != null && tax.getPercentage().compareTo(new BigDecimal(0)) == 1){
                    summary.setTaxTotal(summary.getTaxTotal().add(currencyCLP.calculateAmountByPercentage(summary.getSubTotal(), tax.getPercentage())));
                }
            }
        }
        else{
            summary.setTaxTotal(new BigDecimal(0));
        }


        // coupons
        if(order.getCoupon() != null){
            if(order.getCoupon().getPercentage() != null){
                summary.setDiscountTotal(summary.getDiscountTotal().add(currencyCLP.calculateAmountByPercentage(summary.getSubTotal(), order.getCoupon().getPercentage())));

            }
            else{
                summary.setDiscountTotal(order.getCoupon().getFixedAmount());
            }
        }
        else{
            summary.setDiscountTotal(new BigDecimal(0));
        }

        //TODO: add shipment cost

        //TODO: add option cost

        // total
        summary.setTotal(
                currencyCLP.roundClp(
                        summary.getTotal()
                        .add(summary.getSubTotal())
                        .add(summary.getTaxTotal())
                        .add(summary.getShipmentCost())
                        .subtract(summary.getDiscountTotal())
                )
        );

        return summary;
    }
}
