package com.ecom.order.dalc.repositories;

import com.ecom.order.dalc.entities.ProductDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDiscountRepository extends JpaRepository<ProductDiscount, Long> {
}
