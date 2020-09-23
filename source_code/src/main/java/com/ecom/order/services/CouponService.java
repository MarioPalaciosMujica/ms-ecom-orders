package com.ecom.order.services;

import com.ecom.order.dalc.entities.Coupon;
import com.ecom.order.dalc.repositories.ICouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CouponService {

    @Autowired private ICouponRepository couponRepository;

    public Coupon save(Coupon entity){
        entity.setIdCoupon(null);
        entity.setActive(true);
        entity.setCreated(new Date());
        entity.setModified(null);
        return couponRepository.save(entity);
    }

    public Coupon findById(Long id){
        Optional<Coupon> entity = couponRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public List<Coupon> findAll(){
        return couponRepository.findAll();
    }

    public boolean update(@NotNull Coupon entity){
        Coupon original = this.findById(entity.getIdCoupon());
        if(original != null){
            entity.setCreated(original.getCreated());
            entity.setModified(new Date());
            couponRepository.save(entity);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deleteById(Long id){
        if(this.findById(id) != null){
            couponRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    public Coupon findActiveByCode(String code){
        Optional<Coupon> entity = couponRepository.findActiveByCode(code);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

}
