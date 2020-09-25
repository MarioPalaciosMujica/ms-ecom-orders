package com.ecom.order.api.mapping;

import com.ecom.order.api.models.PaymentStatusModel;
import com.ecom.order.dalc.entities.PaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentStatusMap {

    @Autowired private PaymentMethodMap paymentMethodMap;

    public PaymentStatusModel toModel(PaymentStatus entity){
        if(entity != null){
            PaymentStatusModel model = new PaymentStatusModel();
            model.setIdPaymentStatus(entity.getIdPaymentStatus());
            model.setPaid(entity.isPaid());
            model.setResponseCode(entity.getResponseCode());
            model.setStatusName(entity.getStatusName());
            model.setPaymentMethod(paymentMethodMap.toModel(entity.getPaymentMethod()));
            return model;
        }
        else{
            return null;
        }
    }

    public PaymentStatus toEntity(PaymentStatusModel model){
        if(model != null){
            PaymentStatus entity = new PaymentStatus();
            entity.setIdPaymentStatus(model.getIdPaymentStatus());
            entity.setPaid(model.isPaid());
            entity.setResponseCode(model.getResponseCode());
            entity.setStatusName(model.getStatusName());
            entity.setPaymentMethod(paymentMethodMap.toEntity(model.getPaymentMethod()));
            return entity;
        }
        else{
            return null;
        }
    }

    public List<PaymentStatusModel> toModelList(List<PaymentStatus> listEntity){
        List<PaymentStatusModel> modelList = new ArrayList<>();
        for (PaymentStatus entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<PaymentStatus> toEntityList(List<PaymentStatusModel> listModel){
        List<PaymentStatus> entityList = new ArrayList<>();
        for (PaymentStatusModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
