package com.ecom.order.dalc.repositories;

import com.ecom.order.dalc.entities.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPaymentStatusRepository extends JpaRepository<PaymentStatus, Long> {

    @Query("select p from PaymentStatus p where p.responseCode = :responseCode")
    Optional<PaymentStatus> findByResponseCode(@Param("responseCode") String responseCode);

    @Query("select p from PaymentStatus p join p.paymentMethod m where p.responseCode = :responseCode and m.paymentMethodCode = :paymentMethod")
    Optional<PaymentStatus> findByResponseCodeAndPaymentMethod(
            @Param("responseCode") String responseCode,
            @Param("paymentMethod") String paymentMethod
    );
}
