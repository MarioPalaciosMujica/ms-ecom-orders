package com.ecom.order.dalc.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "tbl_product_discounts")
@NoArgsConstructor
public class ProductDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_discount", updatable = false, nullable = false, unique = true)
    private Long idProductDiscount;

    @Column(name = "name", nullable = false)
    @Size(min = 2, max = 50, message = "name size invalid")
    private String name;

    @Column(name = "description")
    @Size(max = 255, message = "description size not valid")
    private String description;

    @Column(name = "percentage")
    private BigDecimal percentage;

    @Column(name = "fixed_amount")
    private BigDecimal fixedAmount;

    @Column(name = "ms_product_id_discount")
    private Long msProductIdDiscount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product")
    private Product product;

    // GETTERS AND SETTERS

    public Long getIdProductDiscount() {
        return idProductDiscount;
    }

    public void setIdProductDiscount(Long idProductDiscount) {
        this.idProductDiscount = idProductDiscount;
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

    public Long getMsProductIdDiscount() {
        return msProductIdDiscount;
    }

    public void setMsProductIdDiscount(Long msProductIdDiscount) {
        this.msProductIdDiscount = msProductIdDiscount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
