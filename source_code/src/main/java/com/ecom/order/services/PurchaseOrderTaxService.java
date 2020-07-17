package com.ecom.order.services;

import com.ecom.order.dalc.entities.PurchaseOrderTax;
import com.ecom.order.dalc.repositories.IPurchaseOrderTaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderTaxService {

    @Autowired private IPurchaseOrderTaxRepository purchaseOrderTaxRepository;

    public PurchaseOrderTax save(@NotNull PurchaseOrderTax entity){
        entity.setIdProductTax(null);
        purchaseOrderTaxRepository.save(entity);
        return entity;
    }

    public PurchaseOrderTax findById(@NotNull Long id){
        Optional<PurchaseOrderTax> entity = purchaseOrderTaxRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public List<PurchaseOrderTax> findAll(){
        return purchaseOrderTaxRepository.findAll();
    }
}
