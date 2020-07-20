package com.ecom.order.dalc.repositories;

import com.ecom.order.dalc.entities.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaxRepository extends JpaRepository<Tax, Long> {
}
