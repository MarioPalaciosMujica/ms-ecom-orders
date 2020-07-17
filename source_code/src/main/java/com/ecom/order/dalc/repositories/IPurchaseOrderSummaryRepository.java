package com.ecom.order.dalc.repositories;

import com.ecom.order.dalc.entities.PurchaseOrderSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPurchaseOrderSummaryRepository extends JpaRepository<PurchaseOrderSummary, Long> {
}
