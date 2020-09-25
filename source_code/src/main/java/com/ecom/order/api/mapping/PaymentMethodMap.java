package com.ecom.order.api.mapping;

import com.ecom.order.api.models.PaymentMethodModel;
import com.ecom.order.dalc.entities.PaymentMethod;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentMethodMap {

    public PaymentMethodModel toModel(PaymentMethod entity){
        if(entity != null){
            PaymentMethodModel model = new PaymentMethodModel();
            model.setIdPaymentMethod(entity.getIdPaymentMethod());
            model.setPaymentMethodCode(entity.getPaymentMethodCode());
            model.setPaymentMethodName(entity.getPaymentMethodName());
            return model;
        }
        else{
            return null;
        }
    }

    public PaymentMethod toEntity(PaymentMethodModel model){
        if(model != null){
            PaymentMethod entity = new PaymentMethod();
            entity.setIdPaymentMethod(model.getIdPaymentMethod());
            entity.setPaymentMethodCode(model.getPaymentMethodCode());
            entity.setPaymentMethodName(model.getPaymentMethodName());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<PaymentMethodModel> toModelList(List<PaymentMethod> listEntity){
        List<PaymentMethodModel> modelList = new ArrayList<>();
        for (PaymentMethod entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<PaymentMethod> toEntityList(List<PaymentMethodModel> listModel){
        List<PaymentMethod> entityList = new ArrayList<>();
        for (PaymentMethodModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
