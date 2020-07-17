package com.ecom.order.api.mapping;

import com.ecom.order.api.models.PurchaseOrderCouponModel;
import com.ecom.order.dalc.entities.PurchaseOrderCoupon;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PurchaseOrderCouponMap {

    public PurchaseOrderCouponModel toModel(PurchaseOrderCoupon entity){
        if(entity != null){
            PurchaseOrderCouponModel model = new PurchaseOrderCouponModel();
            model.setIdPurchaseOrderCoupon(entity.getIdPurchaseOrderCoupon());
            model.setCode(entity.getCode());
            model.setName(entity.getName());
            model.setPercentage(entity.getPercentage());
            model.setFixedAmount(entity.getFixedAmount());
            model.setMsProductIdCoupon(entity.getMsProductIdCoupon());
            return model;
        }
        else{
            return null;
        }
    }

    public PurchaseOrderCoupon toEntity(PurchaseOrderCouponModel model){
        if(model != null){
            PurchaseOrderCoupon entity = new PurchaseOrderCoupon();
            entity.setIdPurchaseOrderCoupon(model.getIdPurchaseOrderCoupon());
            entity.setCode(model.getCode());
            entity.setName(model.getName());
            entity.setPercentage(model.getPercentage());
            entity.setFixedAmount(model.getFixedAmount());
            entity.setMsProductIdCoupon(model.getMsProductIdCoupon());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<PurchaseOrderCouponModel> toModelList(List<PurchaseOrderCoupon> listEntity){
        List<PurchaseOrderCouponModel> modelList = new ArrayList<>();
        for (PurchaseOrderCoupon entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<PurchaseOrderCoupon> toEntityList(List<PurchaseOrderCouponModel> listModel){
        List<PurchaseOrderCoupon> entityList = new ArrayList<>();
        for (PurchaseOrderCouponModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
