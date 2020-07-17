package com.ecom.order.services;

import com.ecom.order.dalc.entities.PurchaseOrderCoupon;
import com.ecom.order.dalc.repositories.IPurchaseOrderCouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderCouponService {

    @Autowired private IPurchaseOrderCouponRepository purchaseOrderCouponRepository;

    public PurchaseOrderCoupon save(PurchaseOrderCoupon entity){
        entity.setIdPurchaseOrderCoupon(null);
        return purchaseOrderCouponRepository.save(entity);
    }

    public PurchaseOrderCoupon findById(Long id){
        Optional<PurchaseOrderCoupon> entity = purchaseOrderCouponRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public List<PurchaseOrderCoupon> findAll(){
        return purchaseOrderCouponRepository.findAll();
    }

}
