package com.ecom.order.services;

import com.ecom.order.dalc.entities.Product;
import com.ecom.order.dalc.entities.PurchaseOrder;
import com.ecom.order.dalc.repositories.IPurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PurchaseOrderService {

    @Autowired private IPurchaseOrderRepository purchaseOrderRepository;
    @Autowired private PurchaseOrderSummaryService purchaseOrderSummaryService;
    @Autowired private PurchaseOrderCouponService purchaseOrderCouponService;
    @Autowired private ProductService productService;

    public PurchaseOrder save(PurchaseOrder entity){
        entity.setIdPurchaseOrder(null);
        entity.setCreated(new Date());
        entity.setModified(null);
        entity.setPurchaseOrderSummary(purchaseOrderSummaryService.save(entity.getPurchaseOrderSummary()));
        if(entity.getPurchaseOrderCoupon() != null){
            entity.setPurchaseOrderCoupon(purchaseOrderCouponService.save(entity.getPurchaseOrderCoupon()));
        }

        Set<Product> productSet = entity.getProducts();
        entity.setProducts(null);
        entity = purchaseOrderRepository.save(entity);

        for (Product product : productSet){
            product.setPurchaseOrder(entity);
            productService.save(product);
        }
        return entity;
    }

    public PurchaseOrder findById(@NotNull Long id){
        Optional<PurchaseOrder> entity = purchaseOrderRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public List<PurchaseOrder> findAll(){
        return purchaseOrderRepository.findAll();
    }

    public boolean update(@NotNull PurchaseOrder entity){
        PurchaseOrder original = this.findById(entity.getIdPurchaseOrder());
        if(original != null){
            entity.setProducts(null);
            entity.setCreated(original.getCreated());
            entity.setModified(new Date());
            purchaseOrderRepository.save(entity);
            return true;
        }
        else {
            return false;
        }
    }

    public List<PurchaseOrder> findAllByStatus(Long idPurchaseOrderStatus){
        return purchaseOrderRepository.findAllByStatus(idPurchaseOrderStatus);
    }
}
