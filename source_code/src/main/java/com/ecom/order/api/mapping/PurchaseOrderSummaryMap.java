package com.ecom.order.api.mapping;

import com.ecom.order.api.models.PurchaseOrderSummaryModel;
import com.ecom.order.dalc.entities.PurchaseOrderSummary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PurchaseOrderSummaryMap {

    public PurchaseOrderSummaryModel toModel(PurchaseOrderSummary entity){
        if(entity != null){
            PurchaseOrderSummaryModel model = new PurchaseOrderSummaryModel();
            model.setIdPurchaseOrderSummary(entity.getIdPurchaseOrderSummary());
            model.setSubTotal(entity.getSubTotal());
            model.setTaxTotal(entity.getTaxTotal());
            model.setShipmentCost(entity.getShipmentCost());
            model.setDiscountTotal(entity.getDiscountTotal());
            model.setTotal(entity.getTotal());
            return model;
        }
        else{
            return null;
        }
    }

    public PurchaseOrderSummary toEntity(PurchaseOrderSummaryModel model){
        if(model != null){
            PurchaseOrderSummary entity = new PurchaseOrderSummary();
            entity.setIdPurchaseOrderSummary(model.getIdPurchaseOrderSummary());
            entity.setSubTotal(model.getSubTotal());
            entity.setTaxTotal(model.getTaxTotal());
            entity.setShipmentCost(model.getShipmentCost());
            entity.setDiscountTotal(model.getDiscountTotal());
            entity.setTotal(model.getTotal());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<PurchaseOrderSummaryModel> toModelList(List<PurchaseOrderSummary> listEntity){
        List<PurchaseOrderSummaryModel> modelList = new ArrayList<>();
        for (PurchaseOrderSummary entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<PurchaseOrderSummary> toEntityList(List<PurchaseOrderSummaryModel> listModel){
        List<PurchaseOrderSummary> entityList = new ArrayList<>();
        for (PurchaseOrderSummaryModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
