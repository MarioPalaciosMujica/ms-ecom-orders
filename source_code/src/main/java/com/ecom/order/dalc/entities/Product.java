package com.ecom.order.dalc.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "tbl_products")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", updatable = false, nullable = false, unique = true)
    private Long idProduct;

    @Column(name = "barcode")
    @Size(max = 13)
    private String barcode;

    @Column(name = "title", nullable = false)
    @Size(min = 2, max = 50)
    private String title;

    @Column(name = "description")
    @Size(max = 1000)
    private String description;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "is_sale", nullable = false)
    private boolean isSale;

    @Column(name = "discount_percentage")
    private BigDecimal discountPercentage;

    @Column(name = "current_base_price")
    private BigDecimal currentBasePrice;

    @Column(name = "current_total_price")
    private BigDecimal currentTotalPrice;

    @Column(name = "is_capacity_qty", nullable = false)
    private boolean isCapacityQty;

    @Column(name = "image_src")
    @Size(max = 255)
    private String imageSrc;

    @Column(name = "ms_product_id_product")
    private Long msProductIdProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_purchase_order")
    private PurchaseOrder purchaseOrder;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_variant")
    private Variant variant;


    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public BigDecimal getCurrentBasePrice() {
        return currentBasePrice;
    }

    public void setCurrentBasePrice(BigDecimal currentBasePrice) {
        this.currentBasePrice = currentBasePrice;
    }

    public BigDecimal getCurrentTotalPrice() {
        return currentTotalPrice;
    }

    public void setCurrentTotalPrice(BigDecimal currentTotalPrice) {
        this.currentTotalPrice = currentTotalPrice;
    }

    public boolean isCapacityQty() {
        return isCapacityQty;
    }

    public void setCapacityQty(boolean capacityQty) {
        isCapacityQty = capacityQty;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public Long getMsProductIdProduct() {
        return msProductIdProduct;
    }

    public void setMsProductIdProduct(Long msProductIdProduct) {
        this.msProductIdProduct = msProductIdProduct;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public Variant getVariant() {
        return variant;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }
}
