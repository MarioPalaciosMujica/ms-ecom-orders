package com.ecom.order.dalc.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tbl_purchase_order_summaries")
@NoArgsConstructor
public class PurchaseOrderSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purchase_order_summary", updatable = false, nullable = false, unique = true)
    private Long idOrderSummary;

    @Column(name = "sub_total", nullable = false)
    private BigDecimal subTotal;

    @Column(name = "tax_total", nullable = false)
    private BigDecimal taxTotal;

    @Column(name = "shipment_cost", nullable = false)
    private BigDecimal shipmentCost;

    @Column(name = "discount_total", nullable = false)
    private BigDecimal discountTotal;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "purchaseOrderSummary")
    private PurchaseOrder purchaseOrder;


    // GETTERS AND SETTERS

    public Long getIdOrderSummary() {
        return idOrderSummary;
    }

    public void setIdOrderSummary(Long idOrderSummary) {
        this.idOrderSummary = idOrderSummary;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(BigDecimal taxTotal) {
        this.taxTotal = taxTotal;
    }

    public BigDecimal getShipmentCost() {
        return shipmentCost;
    }

    public void setShipmentCost(BigDecimal shipmentCost) {
        this.shipmentCost = shipmentCost;
    }

    public BigDecimal getDiscountTotal() {
        return discountTotal;
    }

    public void setDiscountTotal(BigDecimal discountTotal) {
        this.discountTotal = discountTotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
}
