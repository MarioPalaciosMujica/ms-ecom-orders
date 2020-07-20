package com.ecom.order.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PurchaseOrderSummaryModel {

    @JsonProperty("idPurchaseOrderSummary")
    private Long idPurchaseOrderSummary;

    @JsonProperty("subTotal")
    private BigDecimal subTotal;

    @JsonProperty("taxTotal")
    private BigDecimal taxTotal;

    @JsonProperty("shipmentCost")
    private BigDecimal shipmentCost;

    @JsonProperty("discountTotal")
    private BigDecimal discountTotal;

    @JsonProperty("total")
    private BigDecimal total;
}
