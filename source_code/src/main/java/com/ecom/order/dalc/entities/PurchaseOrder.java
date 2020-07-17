package com.ecom.order.dalc.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tbl_purchase_orders")
@NoArgsConstructor
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purchase_order", updatable = false, nullable = false, unique = true)
    private Long idPurchaseOrder;

    @Column(name = "code")
    @Size(max = 13, message = "code size invalid")
    private String code;

    @Column(name = "is_order_paid", nullable = false)
    private boolean isOrderPaid;

    @Column(name = "created", nullable = false)
    private Date created;

    @Column(name = "modified")
    private Date modified;

    @Column(name = "ms_user_accounts_id_account")
    private Long msUserAccountsIdAccount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_purchase_order_summary")
    private PurchaseOrderSummary purchaseOrderSummary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_purchase_order_status")
    private PurchaseOrderStatus purchaseOrderStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_purchase_order_coupon")
    private PurchaseOrderCoupon purchaseOrderCoupon;

    @OneToMany(mappedBy = "purchaseOrder", fetch = FetchType.LAZY)
    private Set<Product> products;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_purchase_order_tax")
    private PurchaseOrderTax purchaseOrderTax;


    public Long getIdPurchaseOrder() {
        return idPurchaseOrder;
    }

    public void setIdPurchaseOrder(Long idPurchaseOrder) {
        this.idPurchaseOrder = idPurchaseOrder;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isOrderPaid() {
        return isOrderPaid;
    }

    public void setOrderPaid(boolean orderPaid) {
        isOrderPaid = orderPaid;
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

    public Long getMsUserAccountsIdAccount() {
        return msUserAccountsIdAccount;
    }

    public void setMsUserAccountsIdAccount(Long msUserAccountsIdAccount) {
        this.msUserAccountsIdAccount = msUserAccountsIdAccount;
    }

    public PurchaseOrderSummary getPurchaseOrderSummary() {
        return purchaseOrderSummary;
    }

    public void setPurchaseOrderSummary(PurchaseOrderSummary purchaseOrderSummary) {
        this.purchaseOrderSummary = purchaseOrderSummary;
    }

    public PurchaseOrderStatus getPurchaseOrderStatus() {
        return purchaseOrderStatus;
    }

    public void setPurchaseOrderStatus(PurchaseOrderStatus purchaseOrderStatus) {
        this.purchaseOrderStatus = purchaseOrderStatus;
    }

    public PurchaseOrderCoupon getPurchaseOrderCoupon() {
        return purchaseOrderCoupon;
    }

    public void setPurchaseOrderCoupon(PurchaseOrderCoupon purchaseOrderCoupon) {
        this.purchaseOrderCoupon = purchaseOrderCoupon;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public PurchaseOrderTax getPurchaseOrderTax() {
        return purchaseOrderTax;
    }

    public void setPurchaseOrderTax(PurchaseOrderTax purchaseOrderTax) {
        this.purchaseOrderTax = purchaseOrderTax;
    }
}
