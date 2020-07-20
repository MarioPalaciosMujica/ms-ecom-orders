package com.ecom.order.dalc.repositories;

import com.ecom.order.dalc.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICouponRepository extends JpaRepository<Coupon, Long> {
}
