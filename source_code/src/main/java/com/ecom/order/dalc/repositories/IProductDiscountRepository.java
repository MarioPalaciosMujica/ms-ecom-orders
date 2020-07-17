package com.ecom.order.dalc.repositories;

import com.ecom.order.dalc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDiscountRepository extends JpaRepository<Product, Long> {
}
