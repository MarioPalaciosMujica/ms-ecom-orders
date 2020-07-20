package com.ecom.order.services;

import com.ecom.order.dalc.entities.Tax;
import com.ecom.order.dalc.repositories.ITaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaxService {

    @Autowired private ITaxRepository taxRepository;

    public Tax save(@NotNull Tax entity){
        entity.setIdTax(null);
        taxRepository.save(entity);
        return entity;
    }

    public Tax findById(@NotNull Long id){
        Optional<Tax> entity = taxRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public List<Tax> findAll(){
        return taxRepository.findAll();
    }

    public boolean update(@NotNull Tax entity){
        Tax original = this.findById(entity.getIdTax());
        if(original != null){
            entity.setCreated(original.getCreated());
            entity.setModified(new Date());
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deleteById(@NotNull Long id){
        if(this.findById(id) != null){
            taxRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
