package com.ecom.order.api.mapping;

import com.ecom.order.api.models.PurchaseOrderStatusModel;
import com.ecom.order.dalc.entities.PurchaseOrderStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PurchaseOrderStatusMap {

    public PurchaseOrderStatusModel toModel(PurchaseOrderStatus entity){
        if(entity != null){
            PurchaseOrderStatusModel model = new PurchaseOrderStatusModel();
            model.setIdPurchaseOrderStatus(entity.getIdPurchaseOrderStatus());
            model.setName(entity.getName());
            model.setDescription(entity.getDescription());
            model.setCreated(entity.getCreated());
            model.setModified(entity.getModified());
            model.setStage(entity.getStage());
            return model;
        }
        else{
            return null;
        }
    }

    public PurchaseOrderStatus toEntity(PurchaseOrderStatusModel model){
        if(model != null){
            PurchaseOrderStatus entity = new PurchaseOrderStatus();
            entity.setIdPurchaseOrderStatus(model.getIdPurchaseOrderStatus());
            entity.setName(model.getName());
            entity.setDescription(model.getDescription());
            entity.setCreated(model.getCreated());
            entity.setModified(model.getModified());
            entity.setStage(model.getStage());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<PurchaseOrderStatusModel> toModelList(List<PurchaseOrderStatus> listEntity){
        List<PurchaseOrderStatusModel> modelList = new ArrayList<>();
        for (PurchaseOrderStatus entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<PurchaseOrderStatus> toEntityList(List<PurchaseOrderStatusModel> listModel){
        List<PurchaseOrderStatus> entityList = new ArrayList<>();
        for (PurchaseOrderStatusModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
