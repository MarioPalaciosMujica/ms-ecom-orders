package com.ecom.order.services;

import com.ecom.order.dalc.entities.ProductDiscount;
import com.ecom.order.dalc.repositories.IProductDiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDiscountService {

    @Autowired private IProductDiscountRepository productDiscountRepository;

    public ProductDiscount save(ProductDiscount entity){
        entity.setIdProductDiscount(null);
        return productDiscountRepository.save(entity);
    }

    public ProductDiscount findById(Long id){
        Optional<ProductDiscount> entity = productDiscountRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public List<ProductDiscount> findAll(){
        return productDiscountRepository.findAll();
    }
}
