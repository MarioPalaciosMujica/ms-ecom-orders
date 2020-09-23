package com.ecom.order.dalc.repositories;

import com.ecom.order.dalc.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICouponRepository extends JpaRepository<Coupon, Long> {

    @Query("select c from Coupon c where c.code = :code and c.isActive = true")
    Optional<Coupon> findActiveByCode(@Param("code") String code);
}
