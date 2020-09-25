package com.ecom.order.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CouponModel {

    @JsonProperty("idCoupon")
    private Long idCoupon;

    @JsonProperty("code")
    private String code;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("percentage")
    private BigDecimal percentage;

    @JsonProperty("fixedAmount")
    private BigDecimal fixedAmount;

    @JsonProperty("expirationDate")
    private String expirationDate;

    @JsonProperty("isActive")
    private boolean isActive;

    @JsonProperty("created")
    private String created;

    @JsonProperty("modified")
    private String modified;
}
