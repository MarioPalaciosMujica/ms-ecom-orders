package com.ecom.order.services;

import com.ecom.order.dalc.entities.PurchaseOrderSummary;
import com.ecom.order.dalc.repositories.IPurchaseOrderSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderSummaryService {

    @Autowired
    private IPurchaseOrderSummaryRepository purchaseOrderSummaryRepository;

    public PurchaseOrderSummary save(@NotNull PurchaseOrderSummary entity){
        entity.setIdOrderSummary(null);
        purchaseOrderSummaryRepository.save(entity);
        return entity;
    }

    public PurchaseOrderSummary findById(@NotNull Long id){
        Optional<PurchaseOrderSummary> entity = purchaseOrderSummaryRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else {
            return null;
        }
    }

    public List<PurchaseOrderSummary> findAll(){
        return purchaseOrderSummaryRepository.findAll();
    }
}
