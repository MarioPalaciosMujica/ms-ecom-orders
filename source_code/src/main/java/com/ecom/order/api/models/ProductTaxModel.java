package com.ecom.order.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductTaxModel {

    @JsonProperty("idProductTax")
    private Long idProductTax;

    @JsonProperty("name")
    private String name;

    @JsonProperty("percentage")
    private BigDecimal percentage;

    @JsonProperty("fixedAmount")
    private BigDecimal fixedAmount;
}
