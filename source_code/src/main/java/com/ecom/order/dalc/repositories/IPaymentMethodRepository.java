package com.ecom.order.dalc.repositories;

import com.ecom.order.dalc.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

    @Query("select p from PaymentMethod p where p.paymentMethodCode = :code")
    Optional<PaymentMethod> findByCode(@Param("code") String code);
}
