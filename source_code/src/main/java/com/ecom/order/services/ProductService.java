package com.ecom.order.services;

import com.ecom.order.dalc.entities.Product;
import com.ecom.order.dalc.entities.ProductDiscount;
import com.ecom.order.dalc.entities.ProductTax;
import com.ecom.order.dalc.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {

    @Autowired private IProductRepository productRepository;
    @Autowired private ProductDiscountService productDiscountService;
    @Autowired private ProductTaxService productTaxService;
    @Autowired private PurchaseOrderTaxService purchaseOrderTaxService;

    public Product save(@NotNull Product entity){
        entity.setMsProductIdProduct(entity.getIdProduct());
        entity.setIdProduct(null);

        Set<ProductDiscount> discountSet = entity.getProductDiscounts();
//        Set<ProductTax> taxSet = entity.getProductTaxes();

        entity.setProductDiscounts(null);
        entity.setProductTaxes(null);
        entity = productRepository.save(entity);

        for (ProductDiscount discount : discountSet){
            discount.setProduct(entity);
            productDiscountService.save(discount);
        }
//        for (ProductTax tax : taxSet){
//            tax.setProduct(entity);
//            taxService.save(tax);
//        }
        return entity;
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
