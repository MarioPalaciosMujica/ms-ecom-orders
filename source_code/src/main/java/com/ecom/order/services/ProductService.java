package com.ecom.order.services;

import com.ecom.order.dalc.entities.Product;
import com.ecom.order.dalc.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired private IProductRepository productRepository;
    @Autowired private TaxService taxService;

    public Product save(@NotNull Product entity){
        entity.setMsProductIdProduct(entity.getIdProduct());
        entity.setIdProduct(null);
        return productRepository.save(entity);
    }

    public Product findById(@NotNull Long id){
        Optional<Product> entity = productRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
