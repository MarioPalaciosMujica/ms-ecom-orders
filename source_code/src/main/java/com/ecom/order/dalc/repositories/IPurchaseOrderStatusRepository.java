package com.ecom.order.dalc.repositories;

import com.ecom.order.dalc.entities.PurchaseOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPurchaseOrderStatusRepository extends JpaRepository<PurchaseOrderStatus, Long> {

    @Query("select p from PurchaseOrderStatus p order by p.stage asc")
    List<PurchaseOrderStatus> findAll();

    @Query("select p from PurchaseOrderStatus p where p.statusCode = :code")
    Optional<PurchaseOrderStatus> findByCode(@Param("code") String code);
}
