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
    @Size(max = 13, message = "barcode size invalid")
    private String barcode;

    @Column(name = "title", nullable = false)
    @Size(min = 2, max = 50, message = "name size invalid")
    private String title;

    @Column(name = "description")
    @Size(max = 1000, message = "description size not valid")
    private String description;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "is_sale", nullable = false)
    private boolean isSale;

    @Column(name = "discount_percentage")
    private BigDecimal discountPercentage;

    @Column(name = "price_discount")
    private BigDecimal priceDiscount;

    @Column(name = "image_src")
    @Size(max = 255, message = "imageSrc size invalid")
    private String imageSrc;

    @Column(name = "ms_product_id_product")
    private Long msProductIdProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_purchase_order")
    private PurchaseOrder purchaseOrder;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tbr_products_materials",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_material")
    )
    private Set<Material> materials;


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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public BigDecimal getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(BigDecimal priceDiscount) {
        this.priceDiscount = priceDiscount;
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

    public Set<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(Set<Material> materials) {
        this.materials = materials;
    }
}
