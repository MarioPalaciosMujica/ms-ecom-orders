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

    @Column(name = "name", nullable = false)
    @Size(min = 2, max = 50, message = "name size invalid")
    private String name;

    @Column(name = "description")
    @Size(max = 1000, message = "description size not valid")
    private String description;

    @Column(name = "quantity", nullable = false)
    private int qty;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "url_image")
    @Size(max = 255, message = "urlImage size invalid")
    private String urlImage;

    @Column(name = "ms_product_id_product")
    private Long msProductIdProduct;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<ProductDiscount> discounts;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tbr_products_taxes",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_product_tax")
    )
    private Set<ProductTax> productTaxes;

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


    // GETTERS AND SETTERS

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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Long getMsProductIdProduct() {
        return msProductIdProduct;
    }

    public void setMsProductIdProduct(Long msProductIdProduct) {
        this.msProductIdProduct = msProductIdProduct;
    }

    public Set<ProductDiscount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Set<ProductDiscount> discounts) {
        this.discounts = discounts;
    }

    public Set<ProductTax> getProductTaxes() {
        return productTaxes;
    }

    public void setProductTaxes(Set<ProductTax> productTaxes) {
        this.productTaxes = productTaxes;
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
