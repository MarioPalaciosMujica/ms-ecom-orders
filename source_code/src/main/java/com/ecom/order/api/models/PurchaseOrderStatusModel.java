package com.ecom.order.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PurchaseOrderStatusModel {

    @JsonProperty("idPurchaseOrderStatus")
    private Long idPurchaseOrderStatus;

    @JsonProperty("status_code")
    private String statusCode;

    @JsonProperty("status_name")
    private String statusName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("stage")
    private Integer stage;

    @JsonProperty("isUpdatable")
    private boolean isUpdatable;
}
