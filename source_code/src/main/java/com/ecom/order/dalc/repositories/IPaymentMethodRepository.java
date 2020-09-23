package com.ecom.order.dalc.repositories;

import com.ecom.order.dalc.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {


}
