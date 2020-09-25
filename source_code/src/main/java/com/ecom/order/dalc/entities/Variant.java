package com.ecom.order.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "tbl_variants")
@NoArgsConstructor
@AllArgsConstructor
public class Variant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_variant", updatable = false, nullable = false, unique = true)
    private Long idVariant;

    @Column(name = "base_price_amount", nullable = false)
    private BigDecimal basePriceAmount;

    @Column(name = "total_price_amount", nullable = false)
    private BigDecimal totalPriceAmount;

    @Column(name = "unit_quantity")
    private Integer unitQuantity;

    @Column(name = "clients_capacity")
    private Integer clientsCapacity;

    @Column(name = "is_selected")
    private boolean isSelected;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "variant", cascade = CascadeType.ALL)
    private Product product;

    @OneToMany(mappedBy = "variant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Option> options;


    public Long getIdVariant() {
        return idVariant;
    }

    public void setIdVariant(Long idVariant) {
        this.idVariant = idVariant;
    }

    public BigDecimal getBasePriceAmount() {
        return basePriceAmount;
    }

    public void setBasePriceAmount(BigDecimal basePriceAmount) {
        this.basePriceAmount = basePriceAmount;
    }

    public BigDecimal getTotalPriceAmount() {
        return totalPriceAmount;
    }

    public void setTotalPriceAmount(BigDecimal totalPriceAmount) {
        this.totalPriceAmount = totalPriceAmount;
    }

    public Integer getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(Integer unitQuantity) {
        this.unitQuantity = unitQuantity;
    }

    public Integer getClientsCapacity() {
        return clientsCapacity;
    }

    public void setClientsCapacity(Integer clientsCapacity) {
        this.clientsCapacity = clientsCapacity;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }
}
