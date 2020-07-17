package com.ecom.order.api.mapping;

import com.ecom.order.api.models.MaterialModel;
import com.ecom.order.dalc.entities.Material;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class MaterialMap {

    public MaterialModel toModel(Material entity){
        if(entity != null){
            MaterialModel model = new MaterialModel();
            model.setIdMaterial(entity.getIdMaterial());
            model.setBarcode(entity.getBarcode());
            model.setName(entity.getName());
            model.setCreated(entity.getCreated());
            return model;
        }
        else{
            return null;
        }
    }

    public Material toEntity(MaterialModel model){
        if(model != null){
            Material entity = new Material();
            entity.setIdMaterial(model.getIdMaterial());
            entity.setBarcode(model.getBarcode());
            entity.setName(model.getName());
            entity.setCreated(new Date());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<MaterialModel> toModelList(List<Material> listEntity){
        List<MaterialModel> modelList = new ArrayList<>();
        for (Material entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Material> toEntityList(List<MaterialModel> listModel){
        List<Material> entityList = new ArrayList<>();
        for (MaterialModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
