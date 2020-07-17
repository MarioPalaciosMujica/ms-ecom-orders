package com.ecom.order.dalc.repositories;

import com.ecom.order.dalc.entities.PurchaseOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPurchaseOrderStatusRepository extends JpaRepository<PurchaseOrderStatus, Long> {

    @Query("select p from PurchaseOrderStatus p order by p.stage asc")
    List<PurchaseOrderStatus> findAll();
}
