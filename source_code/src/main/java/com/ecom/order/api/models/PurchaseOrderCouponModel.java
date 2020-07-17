package com.ecom.order.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PurchaseOrderCouponModel {

    @JsonProperty("idPurchaseOrderCoupon")
    private Long idPurchaseOrderCoupon;

    @JsonProperty("code")
    private String code;

    @JsonProperty("name")
    private String name;

    @JsonProperty("percentage")
    private BigDecimal percentage;

    @JsonProperty("fixedAmount")
    private BigDecimal fixedAmount;

    @JsonProperty("totalAmount")
    private BigDecimal totalAmount;

    @JsonProperty("msProductIdCoupon")
    private Long msProductIdCoupon;
}
