package com.ecom.order.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class VariantModel {

    @JsonProperty("idVariant")
    private Long idVariant;

    @JsonProperty("basePriceAmount")
    private BigDecimal basePriceAmount;

    @JsonProperty("totalPriceAmount")
    private BigDecimal totalPriceAmount;

    @JsonProperty("unitQuantity")
    private Integer unitQuantity;

    @JsonProperty("clientsCapacity")
    private Integer clientsCapacity;

    @JsonProperty("isSelected")
    private boolean isSelected;

    @JsonProperty("options")
    private List<OptionModel> options;
}
