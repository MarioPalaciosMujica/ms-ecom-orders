package com.ecom.order.dalc.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "tbl_purchase_order_coupons")
@NoArgsConstructor
public class PurchaseOrderCoupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purchase_order_coupon", updatable = false, nullable = false, unique = true)
    private Long idPurchaseOrderCoupon;

    @Column(name = "code")
    @Size(max = 50, message = "code size invalid")
    private String code;

    @Column(name = "name", nullable = false)
    @Size(min = 2, max = 50, message = "name size invalid")
    private String name;

    @Column(name = "percentage")
    private BigDecimal percentage;

    @Column(name = "fixed_amount")
    private BigDecimal fixedAmount;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "ms_product_id_cupon")
    private Long msProductIdCupon;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "cupon")
    private PurchaseOrder purchaseOrder;


    // GETTERS AND SETTERS


    public Long getIdPurchaseOrderCoupon() {
        return idPurchaseOrderCoupon;
    }

    public void setIdPurchaseOrderCoupon(Long idPurchaseOrderCoupon) {
        this.idPurchaseOrderCoupon = idPurchaseOrderCoupon;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public BigDecimal getFixedAmount() {
        return fixedAmount;
    }

    public void setFixedAmount(BigDecimal fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getMsProductIdCupon() {
        return msProductIdCupon;
    }

    public void setMsProductIdCupon(Long msProductIdCupon) {
        this.msProductIdCupon = msProductIdCupon;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
}
