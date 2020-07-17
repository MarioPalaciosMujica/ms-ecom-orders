package com.ecom.order.api.mapping;

import com.ecom.order.api.models.PurchaseOrderModel;
import com.ecom.order.dalc.entities.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Component
public class PurchaseOrderMap {

    @Autowired private PurchaseOrderSummaryMap purchaseOrderSummaryMap;
    @Autowired private PurchaseOrderStatusMap purchaseOrderStatusMap;
    @Autowired private PurchaseOrderCouponMap purchaseOrderCouponMap;
    @Autowired private PurchaseOrderTaxMap purchaseOrderTaxMap;
    @Autowired private ProductMap productMap;

    public PurchaseOrderModel toModel(PurchaseOrder entity){
        if(entity != null){
            PurchaseOrderModel model = new PurchaseOrderModel();
            model.setIdPurchaseOrder(entity.getIdPurchaseOrder());
            model.setOrderPaid(entity.isOrderPaid());
            model.setCreated(this.dateToString(entity.getCreated()));
            model.setModified(entity.getModified());
            model.setMsUserAccountsIdAccount(entity.getMsUserAccountsIdAccount());
            model.setPurchaseOrderSummary(purchaseOrderSummaryMap.toModel(entity.getPurchaseOrderSummary()));
            model.setMsUserAccountsIdAccount(entity.getMsUserAccountsIdAccount());
            model.setPurchaseOrderStatus(purchaseOrderStatusMap.toModel(entity.getPurchaseOrderStatus()));
            model.setPurchaseOrderCoupon(purchaseOrderCouponMap.toModel(entity.getPurchaseOrderCoupon()));
            model.setProducts(productMap.toModelList(new ArrayList<>(entity.getProducts())));
            model.setPurchaseOrderTaxes(purchaseOrderTaxMap.toModelList(new ArrayList<>(entity.getPurchaseOrderTaxes())));
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
            entity.setOrderPaid(model.isOrderPaid());
            entity.setModified(model.getModified());
            entity.setMsUserAccountsIdAccount(model.getMsUserAccountsIdAccount());
            entity.setPurchaseOrderSummary(purchaseOrderSummaryMap.toEntity(model.getPurchaseOrderSummary()));
            entity.setPurchaseOrderStatus(purchaseOrderStatusMap.toEntity(model.getPurchaseOrderStatus()));
            entity.setMsUserAccountsIdAccount(model.getMsUserAccountsIdAccount());
            entity.setPurchaseOrderCoupon(purchaseOrderCouponMap.toEntity(model.getPurchaseOrderCoupon()));
            entity.setProducts(new HashSet<>(productMap.toEntityList(model.getProducts())));
            entity.setPurchaseOrderTaxes(new HashSet<>(purchaseOrderTaxMap.toEntityList(model.getPurchaseOrderTaxes())));
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

    private String dateToString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(date);
    }
}