package com.ecom.order.dalc.repositories;

import com.ecom.order.dalc.entities.PurchaseOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPurchaseOrderStatusRepository extends JpaRepository<PurchaseOrderStatus, Long> {
}
