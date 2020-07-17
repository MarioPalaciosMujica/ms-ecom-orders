package com.ecom.order.dalc.repositories;

import com.ecom.order.dalc.entities.PurchaseOrderTax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPurchaseOrderTaxRepository extends JpaRepository<PurchaseOrderTax, Long> {
}
