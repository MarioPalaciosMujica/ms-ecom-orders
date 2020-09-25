package com.ecom.order.api.mapping;

import com.ecom.order.api.models.PurchaseOrderModel;
import com.ecom.order.dalc.entities.PurchaseOrder;
import com.ecom.order.tools.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class PurchaseOrderMap {

    @Autowired private PurchaseOrderSummaryMap purchaseOrderSummaryMap;
    @Autowired private PurchaseOrderStatusMap purchaseOrderStatusMap;
    @Autowired private PaymentStatusMap paymentStatusMap;
    @Autowired private CouponMap couponMap;
    @Autowired private TaxMap taxMap;
    @Autowired private ProductMap productMap;
    @Autowired private ShipmentMap shipmentMap;
    @Autowired private DateFormat dateFormat;

    public PurchaseOrderModel toModel(PurchaseOrder entity){
        if(entity != null){
            PurchaseOrderModel model = new PurchaseOrderModel();
            model.setIdPurchaseOrder(entity.getIdPurchaseOrder());
            model.setCode(entity.getCode());
            model.setIdSession(entity.getIdSession());
            model.setIdTransaction(entity.getIdTransaction());
            model.setTransactionDate(dateFormat.dateToString(entity.getTransactionDate()));
            model.setCreated(dateFormat.dateToString(entity.getCreated()));
            model.setModified(dateFormat.dateToString(entity.getModified()));
            model.setMsUserAccountsIdAccount(entity.getMsUserAccountsIdAccount());
            model.setProducts(productMap.toModelList(new ArrayList<>(entity.getProducts())));

            if(entity.getPurchaseOrderSummary() != null){
                model.setPurchaseOrderSummary(purchaseOrderSummaryMap.toModel(entity.getPurchaseOrderSummary()));
            }
            if(entity.getPurchaseOrderStatus() != null){
                model.setPurchaseOrderStatus(purchaseOrderStatusMap.toModel(entity.getPurchaseOrderStatus()));
            }
            if(entity.getPaymentStatus() != null){
                model.setPaymentStatus(paymentStatusMap.toModel(entity.getPaymentStatus()));
            }
            if(entity.getShipment() != null){
                model.setShipment(shipmentMap.toModel(entity.getShipment()));
            }
            if(entity.getCoupon() != null){
                model.setCoupon(couponMap.toModel(entity.getCoupon()));
            }
            if(entity.getTaxes() != null && entity.getTaxes().size() > 0){
                model.setTaxes(taxMap.toModelList(new ArrayList<>(entity.getTaxes())));
            }
            return model;
        }
        else{
            return null;
        }
    }

    public PurchaseOrder toEntity(PurchaseOrderModel model){
        if(model != null){
            PurchaseOrder entity = new PurchaseOrder();
            entity.setIdPurchaseOrder(model.getIdPurchaseOrder());
            entity.setCode(model.getCode());
            entity.setIdSession(model.getIdSession());
            entity.setIdTransaction(model.getIdTransaction());
            entity.setTransactionDate(dateFormat.stringToDate(model.getTransactionDate()));
            entity.setCreated(dateFormat.stringToDate(model.getCreated()));
            entity.setModified(dateFormat.stringToDate(model.getModified()));
            entity.setMsUserAccountsIdAccount(model.getMsUserAccountsIdAccount());
            entity.setProducts(new HashSet<>(productMap.toEntityList(model.getProducts())));

            if(model.getPurchaseOrderStatus() != null){
                entity.setPurchaseOrderStatus(purchaseOrderStatusMap.toEntity(model.getPurchaseOrderStatus()));
            }
            if(model.getPurchaseOrderSummary() != null){
                entity.setPurchaseOrderSummary(purchaseOrderSummaryMap.toEntity(model.getPurchaseOrderSummary()));
            }
            if(model.getPaymentStatus() != null){
                entity.setPaymentStatus(paymentStatusMap.toEntity(model.getPaymentStatus()));
            }
            if(model.getShipment() != null){
                entity.setShipment(shipmentMap.toEntity(model.getShipment()));
            }
            if(model.getCoupon() != null){
                entity.setCoupon(couponMap.toEntity(model.getCoupon()));
            }

            if(model.getTaxes() != null && model.getTaxes().size() > 0){
                entity.setTaxes(new HashSet<>(taxMap.toEntityList(model.getTaxes())));
            }
            return entity;
        }
        else{
            return null;
        }
    }

    public List<PurchaseOrderModel> toModelList(List<PurchaseOrder> listEntity){
        List<PurchaseOrderModel> modelList = new ArrayList<>();
        for (PurchaseOrder entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<PurchaseOrder> toEntityList(List<PurchaseOrderModel> listModel){
        List<PurchaseOrder> entityList = new ArrayList<>();
        for (PurchaseOrderModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
