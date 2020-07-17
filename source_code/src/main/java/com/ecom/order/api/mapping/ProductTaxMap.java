package com.ecom.order.api.mapping;

import com.ecom.order.api.models.ProductTaxModel;
import com.ecom.order.dalc.entities.ProductTax;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductTaxMap {

    public ProductTaxModel toModel(ProductTax entity){
        if(entity != null){
            ProductTaxModel model = new ProductTaxModel();
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

    public ProductTax toEntity(ProductTaxModel model){
        if(model != null){
            ProductTax entity = new ProductTax();
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

    public List<ProductTaxModel> toModelList(List<ProductTax> listEntity){
        List<ProductTaxModel> modelList = new ArrayList<>();
        for (ProductTax entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<ProductTax> toEntityList(List<ProductTaxModel> listModel){
        List<ProductTax> entityList = new ArrayList<>();
        for (ProductTaxModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
