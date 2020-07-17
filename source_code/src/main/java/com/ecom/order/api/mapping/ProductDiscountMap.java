package com.ecom.order.api.mapping;

import com.ecom.order.api.models.ProductDiscountModel;
import com.ecom.order.dalc.entities.ProductDiscount;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDiscountMap {

    public ProductDiscountModel toModel(ProductDiscount entity){
        if(entity != null){
            ProductDiscountModel model = new ProductDiscountModel();
            model.setIdProductDiscount(entity.getIdProductDiscount());
            model.setName(entity.getName());
            model.setPercentage(entity.getPercentage());
            model.setFixedAmount(entity.getFixedAmount());
            model.setMsProductIdDiscount(entity.getMsProductIdDiscount());
            return model;
        }
        else{
            return null;
        }
    }

    public ProductDiscount toEntity(ProductDiscountModel model){
        if(model != null){
            ProductDiscount entity = new ProductDiscount();
            entity.setIdProductDiscount(model.getIdProductDiscount());
            entity.setName(model.getName());
            entity.setPercentage(model.getPercentage());
            entity.setFixedAmount(model.getFixedAmount());
            entity.setMsProductIdDiscount(model.getMsProductIdDiscount());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<ProductDiscountModel> toModelList(List<ProductDiscount> listEntity){
        List<ProductDiscountModel> modelList = new ArrayList<>();
        for (ProductDiscount entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<ProductDiscount> toEntityList(List<ProductDiscountModel> listModel){
        List<ProductDiscount> entityList = new ArrayList<>();
        for (ProductDiscountModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
