package com.ecom.order.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class TaxModel {

    @JsonProperty("idTax")
    private Long idTax;

    @JsonProperty("taxName")
    private String taxName;

    @JsonProperty("percentage")
    private BigDecimal percentage;

    @JsonProperty("isActive")
    private boolean isActive;

    @JsonProperty("created")
    private Date created;

    @JsonProperty("modified")
    private Date modified;
}
