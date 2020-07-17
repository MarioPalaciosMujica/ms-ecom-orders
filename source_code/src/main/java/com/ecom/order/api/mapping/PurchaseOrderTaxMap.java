package com.ecom.order.api.mapping;

import com.ecom.order.api.models.PurchaseOrderTaxModel;
import com.ecom.order.dalc.entities.PurchaseOrderTax;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PurchaseOrderTaxMap {

    public PurchaseOrderTaxModel toModel(PurchaseOrderTax entity){
        if(entity != null){
            PurchaseOrderTaxModel model = new PurchaseOrderTaxModel();
            model.setIdProductTax(entity.getIdProductTax());
            model.setName(entity.getName());
            model.setPercentage(entity.getPercentage());
            model.setFixedAmount(entity.getFixedAmount());
            return model;
        }
        else{
            return null;
        }
    }

    public PurchaseOrderTax toEntity(PurchaseOrderTaxModel model){
        if(model != null){
            PurchaseOrderTax entity = new PurchaseOrderTax();
            entity.setIdProductTax(model.getIdProductTax());
            entity.setName(model.getName());
            entity.setPercentage(model.getPercentage());
            entity.setFixedAmount(model.getFixedAmount());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<PurchaseOrderTaxModel> toModelList(List<PurchaseOrderTax> listEntity){
        List<PurchaseOrderTaxModel> modelList = new ArrayList<>();
        for (PurchaseOrderTax entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<PurchaseOrderTax> toEntityList(List<PurchaseOrderTaxModel> listModel){
        List<PurchaseOrderTax> entityList = new ArrayList<>();
        for (PurchaseOrderTaxModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
