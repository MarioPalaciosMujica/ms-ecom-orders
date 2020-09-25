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
    @Size(max = 13)
    private String code;

    @Column(name = "id_session", nullable = false)
    private String idSession;

    @Column(name = "id_transaction")
    private Long idTransaction;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "created", nullable = false)
    private Date created;

    @Column(name = "modified")
    private Date modified;

    @Column(name = "ms_user_accounts_id_account")
    private Long msUserAccountsIdAccount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_purchase_order_summary")
    private PurchaseOrderSummary purchaseOrderSummary;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_shipment")
    private Shipment shipment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_purchase_order_status")
    private PurchaseOrderStatus purchaseOrderStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_payment_status")
    private PaymentStatus paymentStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_coupon")
    private Coupon coupon;

    @OneToMany(mappedBy = "purchaseOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Product> products;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tbr_purchase_orders_taxes",
            joinColumns = @JoinColumn(name = "id_purchase_order"),
            inverseJoinColumns = @JoinColumn(name = "id_tax")
    )
    private Set<Tax> taxes;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tbr_purchase_orders_coupons",
            joinColumns = @JoinColumn(name = "id_purchase_order"),
            inverseJoinColumns = @JoinColumn(name = "id_coupon")
    )
    private Set<Coupon> coupons;



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

    public String getIdSession() {
        return idSession;
    }

    public void setIdSession(String idSession) {
        this.idSession = idSession;
    }

    public Long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Long idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
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

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public PurchaseOrderStatus getPurchaseOrderStatus() {
        return purchaseOrderStatus;
    }

    public void setPurchaseOrderStatus(PurchaseOrderStatus purchaseOrderStatus) {
        this.purchaseOrderStatus = purchaseOrderStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes(Set<Tax> taxes) {
        this.taxes = taxes;
    }

    public Set<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(Set<Coupon> coupons) {
        this.coupons = coupons;
    }
}
