package com.ecom.order.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "tbl_options")
@NoArgsConstructor
@AllArgsConstructor
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_option", updatable = false, nullable = false, unique = true)
    private Long idOption;

    @Column(name = "option_name", nullable = false, unique = true)
    @Size(min = 2, max = 50)
    private String optionName;

    @Column(name = "amount_percentage")
    private BigDecimal amountPercentage;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_variant")
    private Variant variant;


    public Long getIdOption() {
        return idOption;
    }

    public void setIdOption(Long idOption) {
        this.idOption = idOption;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public BigDecimal getAmountPercentage() {
        return amountPercentage;
    }

    public void setAmountPercentage(BigDecimal amountPercentage) {
        this.amountPercentage = amountPercentage;
    }

    public Variant getVariant() {
        return variant;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }
}
