package com.ecom.order.api.mapping;

import com.ecom.order.api.models.ProductModel;
import com.ecom.order.api.models.VariantModel;
import com.ecom.order.dalc.entities.Product;
import com.ecom.order.dalc.entities.Variant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class ProductMap {

    @Autowired private VariantMap variantMap;

    public ProductModel toModel(Product entity){
        if(entity != null){
            ProductModel model = new ProductModel();
            model.setIdProduct(entity.getIdProduct());
            model.setBarcode(entity.getBarcode());
            model.setTitle(entity.getTitle());
            model.setDescription(entity.getDescription());
            model.setQuantity(entity.getQuantity());
            model.setSale(entity.isSale());
            model.setDiscountPercentage(entity.getDiscountPercentage());
            model.setCurrentBasePrice(entity.getCurrentBasePrice());
            model.setCurrentTotalPrice(entity.getCurrentTotalPrice());
            model.setCapacityQty(entity.isCapacityQty());
            model.setImages(null);
            model.setImageSrc(entity.getImageSrc());
            model.setMsProductIdProduct(entity.getMsProductIdProduct());
            model.setVariants(null);
            model.setVariant(variantMap.toModel(entity.getVariant()));
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
            entity.setTitle(model.getTitle());
            entity.setDescription(model.getDescription());
            entity.setQuantity(model.getQuantity());
            entity.setSale(model.isSale());
            entity.setDiscountPercentage(model.getDiscountPercentage());
            entity.setCurrentBasePrice(model.getCurrentBasePrice());
            entity.setCurrentTotalPrice(model.getCurrentTotalPrice());
            entity.setCapacityQty(model.isCapacityQty());
            entity.setMsProductIdProduct(model.getMsProductIdProduct());
            if(model.getImages() != null){
                entity.setImageSrc(model.getImages().get(0).getSrc());
            }
            else{
                entity.setImageSrc(model.getImageSrc());
            }
            if(model.getVariants() != null){
                for (VariantModel variantModel : model.getVariants()){
                    if(variantModel.isSelected()){
                        entity.setVariant(variantMap.toEntity(variantModel));
                    }
                }
            }
            else{
                entity.setVariant(variantMap.toEntity(model.getVariant()));
            }

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
