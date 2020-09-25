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
            model.setStatusCode(entity.getStatusCode());
            model.setStatusName(entity.getStatusName());
            model.setDescription(entity.getDescription());
            model.setStage(entity.getStage());
            model.setUpdatable(entity.isUpdatable());
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
            entity.setStatusCode(model.getStatusCode());
            entity.setStatusName(model.getStatusName());
            entity.setDescription(model.getDescription());
            entity.setStage(model.getStage());
            entity.setUpdatable(model.isUpdatable());
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
