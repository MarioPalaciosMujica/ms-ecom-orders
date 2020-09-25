package com.ecom.order.api.mapping;

import com.ecom.order.api.models.VariantModel;
import com.ecom.order.dalc.entities.Variant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class VariantMap {

    @Autowired private OptionMap optionMap;

    public VariantModel toModel(Variant entity){
        if(entity != null){
            VariantModel model = new VariantModel();
            model.setIdVariant(entity.getIdVariant());
            model.setBasePriceAmount(entity.getBasePriceAmount());
            model.setTotalPriceAmount(entity.getTotalPriceAmount());
            model.setClientsCapacity(entity.getClientsCapacity());
            model.setUnitQuantity(entity.getUnitQuantity());
            model.setSelected(entity.isSelected());
            model.setOptions(optionMap.toModelList(new ArrayList<>(entity.getOptions())));
            return model;
        }
        else{
            return null;
        }
    }

    public Variant toEntity(VariantModel model){
        if(model != null){
            Variant entity = new Variant();
            entity.setIdVariant(model.getIdVariant());
            entity.setBasePriceAmount(model.getBasePriceAmount());
            entity.setTotalPriceAmount(model.getTotalPriceAmount());
            entity.setClientsCapacity(model.getClientsCapacity());
            entity.setUnitQuantity(model.getUnitQuantity());
            entity.setSelected(model.isSelected());
            entity.setOptions(new HashSet<>(optionMap.toEntityList(model.getOptions())));
            return entity;
        }
        else{
            return null;
        }
    }

    public List<VariantModel> toModelList(List<Variant> listEntity){
        List<VariantModel> modelList = new ArrayList<>();
        for (Variant entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Variant> toEntityList(List<VariantModel> listModel){
        List<Variant> entityList = new ArrayList<>();
        for (VariantModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
