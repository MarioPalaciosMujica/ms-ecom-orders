package com.ecom.order.api.mapping;

import com.ecom.order.api.models.CouponModel;
import com.ecom.order.dalc.entities.Coupon;
import com.ecom.order.tools.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CouponMap {

    @Autowired private DateFormat dateFormat;

    public CouponModel toModel(Coupon entity){
        if(entity != null){
            CouponModel model = new CouponModel();
            model.setIdCoupon(entity.getIdCoupon());
            model.setCode(entity.getCode());
            model.setName(entity.getName());
            model.setDescription(entity.getDescription());
            model.setPercentage(entity.getPercentage());
            model.setFixedAmount(entity.getFixedAmount());
            model.setExpirationDate(dateFormat.dateToString(entity.getExpirationDate()));
            model.setActive(entity.isActive());
            model.setCreated(dateFormat.dateToString(entity.getCreated()));
            model.setModified(dateFormat.dateToString(entity.getModified()));
            return model;
        }
        else{
            return null;
        }
    }

    public Coupon toEntity(CouponModel model){
        if(model != null){
            Coupon entity = new Coupon();
            entity.setIdCoupon(model.getIdCoupon());
            entity.setCode(model.getCode());
            entity.setName(model.getName());
            entity.setDescription(model.getDescription());
            entity.setPercentage(model.getPercentage());
            entity.setFixedAmount(model.getFixedAmount());
            entity.setExpirationDate(dateFormat.datePickerToDate(model.getExpirationDate()));
            entity.setActive(model.isActive());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<CouponModel> toModelList(List<Coupon> listEntity){
        List<CouponModel> modelList = new ArrayList<>();
        for (Coupon entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Coupon> toEntityList(List<CouponModel> listModel){
        List<Coupon> entityList = new ArrayList<>();
        for (CouponModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
