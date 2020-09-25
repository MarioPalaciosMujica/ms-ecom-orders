package com.ecom.order.api.mapping;

import com.ecom.order.api.models.ShipmentModel;
import com.ecom.order.dalc.entities.Shipment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShipmentMap {

    public ShipmentModel toModel(Shipment entity){
        if(entity != null){
            ShipmentModel model = new ShipmentModel();
            model.setIdShipment(entity.getIdShipment());
            model.setAddress(entity.getAddress());
            model.setCountry(entity.getCountry());
            model.setProvinceCommune(entity.getProvinceCommune());
            model.setStateRegion(entity.getStateRegion());
            model.setZipCode(entity.getZipCode());
            model.setShipmentPriceAmount(entity.getShipmentPriceAmount());
            return model;
        }
        else{
            return null;
        }
    }

    public Shipment toEntity(ShipmentModel model){
        if(model != null){
            Shipment entity = new Shipment();
            entity.setIdShipment(model.getIdShipment());
            entity.setAddress(model.getAddress());
            entity.setCountry(model.getCountry());
            entity.setProvinceCommune(model.getProvinceCommune());
            entity.setStateRegion(model.getStateRegion());
            entity.setZipCode(model.getZipCode());
            entity.setShipmentPriceAmount(model.getShipmentPriceAmount());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<ShipmentModel> toModelList(List<Shipment> listEntity){
        List<ShipmentModel> modelList = new ArrayList<>();
        for (Shipment entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Shipment> toEntityList(List<ShipmentModel> listModel){
        List<Shipment> entityList = new ArrayList<>();
        for (ShipmentModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
