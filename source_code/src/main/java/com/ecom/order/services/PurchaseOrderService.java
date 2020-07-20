package com.ecom.order.services;

import com.ecom.order.dalc.entities.Product;
import com.ecom.order.dalc.entities.PurchaseOrder;
import com.ecom.order.dalc.entities.PurchaseOrderSummary;
import com.ecom.order.dalc.entities.Tax;
import com.ecom.order.dalc.repositories.IPurchaseOrderRepository;
import com.ecom.order.tools.CurrencyCLP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PurchaseOrderService {

    @Autowired private IPurchaseOrderRepository purchaseOrderRepository;
    @Autowired private PurchaseOrderSummaryService purchaseOrderSummaryService;
    @Autowired private PurchaseOrderCouponService purchaseOrderCouponService;
    @Autowired private ProductService productService;
    @Autowired private CurrencyCLP currencyCLP;

    public PurchaseOrder save(PurchaseOrder entity){
        entity.setIdPurchaseOrder(null);
        entity.setCreated(new Date());
        entity.setModified(null);
        entity.setPurchaseOrderSummary(purchaseOrderSummaryService.save(entity.getPurchaseOrderSummary()));
        if(entity.getPurchaseOrderCoupon() != null){
            entity.setPurchaseOrderCoupon(purchaseOrderCouponService.save(entity.getPurchaseOrderCoupon()));
        }

        Set<Product> productSet = entity.getProducts();
        entity.setProducts(null);
        entity = purchaseOrderRepository.save(entity);

        for (Product product : productSet){
            product.setPurchaseOrder(entity);
            productService.save(product);
        }
        return entity;
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

    public boolean update(@NotNull PurchaseOrder entity){
        PurchaseOrder original = this.findById(entity.getIdPurchaseOrder());
        if(original != null){
            entity.setProducts(null);
            entity.setCreated(original.getCreated());
            entity.setModified(new Date());
            purchaseOrderRepository.save(entity);
            return true;
        }
        else {
            return false;
        }
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
            if(product.isSale()){
                summary.setSubTotal(summary.getSubTotal().add(product.getPriceDiscount().multiply(new BigDecimal(product.getQuantity()))));
            }
            else{
                summary.setSubTotal(summary.getSubTotal().add(product.getPrice().multiply(new BigDecimal(product.getQuantity()))));
            }
        }

        // taxes
        for (Tax tax : order.getTaxes()){
            if(tax.getPercentage() != null && tax.getPercentage().compareTo(new BigDecimal(0)) == 1){
                summary.setTaxTotal(summary.getTaxTotal().add(currencyCLP.calculateAmountByPercentage(summary.getSubTotal(), tax.getPercentage())));
            }
        }

        // coupons
        if(order.getPurchaseOrderCoupon() != null){
            if(order.getPurchaseOrderCoupon().getPercentage() != null){
                summary.setDiscountTotal(summary.getDiscountTotal().add(currencyCLP.calculateAmountByPercentage(summary.getSubTotal(), order.getPurchaseOrderCoupon().getPercentage())));

            }
            else{
                summary.setDiscountTotal(order.getPurchaseOrderCoupon().getFixedAmount());
            }
        }

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
