package com.ecom.order.dalc.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tbl_coupons")
@NoArgsConstructor
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coupon", updatable = false, nullable = false, unique = true)
    private Long idCoupon;

    @Column(name = "code", nullable = false, unique = true)
    @Size(max = 50)
    private String code;

    @Column(name = "name", nullable = false, unique = true)
    @Size(min = 2, max = 50)
    private String name;

    @Column(name = "description")
    @Size(max = 255)
    private String description;

    @Column(name = "percentage")
    private BigDecimal percentage;

    @Column(name = "fixed_amount")
    private BigDecimal fixedAmount;

    @Column(name = "expiration_date", nullable = false)
    private Date expirationDate;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "created", nullable = false)
    private Date created;

    @Column(name = "modified")
    private Date modified;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tbr_purchase_orders_coupons",
            joinColumns = @JoinColumn(name = "id_coupon"),
            inverseJoinColumns = @JoinColumn(name = "id_purchase_order")
    )
    private Set<PurchaseOrder> purchaseOrders;


    public Long getIdCoupon() {
        return idCoupon;
    }

    public void setIdCoupon(Long idCoupon) {
        this.idCoupon = idCoupon;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Set<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(Set<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }
}
