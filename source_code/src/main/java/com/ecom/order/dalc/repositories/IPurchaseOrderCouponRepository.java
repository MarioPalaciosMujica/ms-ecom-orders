package com.ecom.order.dalc.repositories;

import com.ecom.order.dalc.entities.PurchaseOrderCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPurchaseOrderCouponRepository extends JpaRepository<PurchaseOrderCoupon, Long> {
}
