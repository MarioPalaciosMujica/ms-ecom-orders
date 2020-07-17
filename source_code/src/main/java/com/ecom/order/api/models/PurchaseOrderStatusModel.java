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

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("stage")
    private int stage;

    @JsonProperty("created")
    private Date created;

    @JsonProperty("modified")
    private Date modified;
}
