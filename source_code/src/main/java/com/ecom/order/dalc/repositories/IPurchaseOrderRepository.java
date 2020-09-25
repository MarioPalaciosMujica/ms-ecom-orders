package com.ecom.order.dalc.repositories;

import com.ecom.order.dalc.entities.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

    @Query("select p from PurchaseOrder p order by p.created desc")
    List<PurchaseOrder> findAll();

    @Query("select p from PurchaseOrder p where p.purchaseOrderStatus.idPurchaseOrderStatus = :idPurchaseOrderStatus")
    List<PurchaseOrder> findAllByStatus(@Param("idPurchaseOrderStatus") Long idPurchaseOrderStatus);

}
