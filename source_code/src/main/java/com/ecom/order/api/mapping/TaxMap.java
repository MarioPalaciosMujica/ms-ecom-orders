package com.ecom.order.api.mapping;

import com.ecom.order.api.models.TaxModel;
import com.ecom.order.dalc.entities.Tax;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaxMap {

    public TaxModel toModel(Tax entity){
        if(entity != null){
            TaxModel model = new TaxModel();
            model.setIdTax(entity.getIdTax());
            model.setName(entity.getName());
            model.setPercentage(entity.getPercentage());
            return model;
        }
        else{
            return null;
        }
    }

    public Tax toEntity(TaxModel model){
        if(model != null){
            Tax entity = new Tax();
            entity.setIdTax(model.getIdTax());
            entity.setName(model.getName());
            entity.setPercentage(model.getPercentage());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<TaxModel> toModelList(List<Tax> listEntity){
        List<TaxModel> modelList = new ArrayList<>();
        for (Tax entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Tax> toEntityList(List<TaxModel> listModel){
        List<Tax> entityList = new ArrayList<>();
        for (TaxModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
