package com.ecom.order.services;

import com.ecom.order.dalc.entities.ProductTax;
import com.ecom.order.dalc.repositories.IProductTaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class ProductTaxService {

    @Autowired
    private IProductTaxRepository productTaxRepository;

    public ProductTax save(@NotNull ProductTax entity){
        entity.setIdProductTax(null);
        productTaxRepository.save(entity);
        return entity;
    }

    public ProductTax findById(@NotNull Long id){
        Optional<ProductTax> entity = productTaxRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public List<ProductTax> findAll(){
        return productTaxRepository.findAll();
    }

}
