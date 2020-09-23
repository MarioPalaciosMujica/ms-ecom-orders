package com.ecom.order.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "tbl_payment_statuses")
@NoArgsConstructor
@AllArgsConstructor
public class PaymentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment_status", updatable = false, nullable = false, unique = true)
    private Long idPaymentStatus;

    @Column(name = "status_name", nullable = false)
    @Size(max = 50)
    private String statusName;

    @Column(name = "response_code", nullable = false)
    @Size(max = 50)
    private String responseCode;

    @Column(name = "is_paid", nullable = false)
    private boolean isPaid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_payment_method")
    private PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "paymentStatus", fetch = FetchType.LAZY)
    private Set<PurchaseOrder> purchaseOrders;


    public Long getIdPaymentStatus() {
        return idPaymentStatus;
    }

    public void setIdPaymentStatus(Long idPaymentStatus) {
        this.idPaymentStatus = idPaymentStatus;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Set<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(Set<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }
}
