package com.ecom.order.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductDiscountModel {

    @JsonProperty("idProductDiscount")
    private Long idProductDiscount;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("percentage")
    private BigDecimal percentage;

    @JsonProperty("fixedAmount")
    private BigDecimal fixedAmount;

    @JsonProperty("msProductIdDiscount")
    private Long msProductIdDiscount;
}
