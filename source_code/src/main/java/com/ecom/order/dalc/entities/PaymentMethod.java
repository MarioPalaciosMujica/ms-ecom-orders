package com.ecom.order.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "tbl_payment_methods")
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment_method", updatable = false, nullable = false, unique = true)
    private Long idPaymentMethod;

    @Column(name = "payment_method_code", nullable = false, unique = true)
    @Size(max = 10)
    private String paymentMethodCode;

    @Column(name = "payment_method_name", nullable = false, unique = true)
    @Size(max = 50)
    private String paymentMethodName;

    @OneToMany(mappedBy = "paymentMethod", fetch = FetchType.LAZY)
    private Set<PaymentStatus> paymentStatuses;


    public Long getIdPaymentMethod() {
        return idPaymentMethod;
    }

    public void setIdPaymentMethod(Long idPaymentMethod) {
        this.idPaymentMethod = idPaymentMethod;
    }

    public String getPaymentMethodCode() {
        return paymentMethodCode;
    }

    public void setPaymentMethodCode(String paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }

    public String getPaymentMethodName() {
        return paymentMethodName;
    }

    public void setPaymentMethodName(String paymentMethodName) {
        this.paymentMethodName = paymentMethodName;
    }

    public Set<PaymentStatus> getPaymentStatuses() {
        return paymentStatuses;
    }

    public void setPaymentStatuses(Set<PaymentStatus> paymentStatuses) {
        this.paymentStatuses = paymentStatuses;
    }
}
