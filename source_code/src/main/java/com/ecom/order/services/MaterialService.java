package com.ecom.order.services;

import com.ecom.order.dalc.entities.Material;
import com.ecom.order.dalc.repositories.IMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    @Autowired private IMaterialRepository materialRepository;

    public Material save(@NotNull Material entity){
        entity.setIdMaterial(null);
        entity.setCreated(new Date());
        materialRepository.save(entity);
        return entity;
    }

    public Material findById(@NotNull Long id){
        Optional<Material> entity = materialRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else {
            return null;
        }
    }

    public List<Material> findAll(){
        return materialRepository.findAll();
    }

    public boolean deleteById(Long id){
        if(this.findById(id) != null){
            materialRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }
}
