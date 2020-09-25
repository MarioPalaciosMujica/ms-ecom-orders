package com.ecom.order.services;

import com.ecom.order.dalc.entities.PurchaseOrderStatus;
import com.ecom.order.dalc.repositories.IPurchaseOrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderStatusService {

    @Autowired
    private IPurchaseOrderStatusRepository purchaseOrderStatusRepository;

    public PurchaseOrderStatus save(PurchaseOrderStatus entity){
        entity.setIdPurchaseOrderStatus(null);
        return purchaseOrderStatusRepository.save(entity);
    }

    public PurchaseOrderStatus findById(@NotNull Long id){
        Optional<PurchaseOrderStatus> entity = purchaseOrderStatusRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public List<PurchaseOrderStatus> findAll(){
        return purchaseOrderStatusRepository.findAll();
    }

    public boolean update(@NotNull PurchaseOrderStatus entity){
        PurchaseOrderStatus original = this.findById(entity.getIdPurchaseOrderStatus());
        if(original != null){
            purchaseOrderStatusRepository.save(entity);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteById(@NotNull Long id){
        PurchaseOrderStatus entity = this.findById(id);
        if(entity != null){
            purchaseOrderStatusRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    public PurchaseOrderStatus findByCode(@NotNull String code){
        Optional<PurchaseOrderStatus> entity = purchaseOrderStatusRepository.findByCode(code);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }
}
