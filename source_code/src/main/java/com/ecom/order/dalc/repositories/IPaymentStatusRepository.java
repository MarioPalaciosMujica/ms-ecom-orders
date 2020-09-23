package com.ecom.order.dalc.repositories;

import com.ecom.order.dalc.entities.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentStatusRepository extends JpaRepository<PaymentStatus, Long> {
}
