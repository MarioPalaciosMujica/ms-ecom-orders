package com.ecom.order.api.mapping;

import com.ecom.order.api.models.ProductModel;
import com.ecom.order.dalc.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class ProductMap {

    @Autowired private ProductDiscountMap productDiscountMap;
    @Autowired private ProductTaxMap productTaxMap;
    @Autowired private MaterialMap materialMap;

    public ProductModel toModel(Product entity){
        if(entity != null){
            ProductModel model = new ProductModel();
            model.setIdProduct(entity.getIdProduct());
            model.setBarcode(entity.getBarcode());
            model.setName(entity.getName());
            model.setPrice(entity.getPrice());
            model.setQty(entity.getQty());
            model.setMsProductIdProduct(entity.getMsProductIdProduct());
            model.setImage(null);
            model.setMsProductIdProduct(entity.getMsProductIdProduct());
            model.setUrlImage(entity.getUrlImage());
            model.setProductDiscounts(productDiscountMap.toModelList(new ArrayList<>(entity.getProductDiscounts())));
            model.setProductTaxes(productTaxMap.toModelList(new ArrayList<>(entity.getProductTaxes())));
            model.setMaterials(materialMap.toModelList(new ArrayList<>(entity.getMaterials())));
            return model;
        }
        else{
            return null;
        }
    }

    public Product toEntity(ProductModel model){
        if(model != null){
            Product entity = new Product();
            entity.setIdProduct(model.getIdProduct());
            entity.setBarcode(model.getBarcode());
            entity.setName(model.getName());
            entity.setPrice(model.getPrice());
            entity.setQty(model.getQty());
            entity.setMsProductIdProduct(model.getMsProductIdProduct());
            entity.setUrlImage(entity.getUrlImage());
            entity.setProductDiscounts(new HashSet<>(this.productDiscountMap.toEntityList(model.getProductDiscounts())));
            entity.setProductTaxes(new HashSet<>(this.productTaxMap.toEntityList(model.getProductTaxes())));
            entity.setMaterials(new HashSet<>(this.materialMap.toEntityList(model.getMaterials())));
            return entity;
        }
        else{
            return null;
        }
    }

    public List<ProductModel> toModelList(List<Product> listEntity){
        List<ProductModel> modelList = new ArrayList<>();
        for (Product entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Product> toEntityList(List<ProductModel> listModel){
        List<Product> entityList = new ArrayList<>();
        for (ProductModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
