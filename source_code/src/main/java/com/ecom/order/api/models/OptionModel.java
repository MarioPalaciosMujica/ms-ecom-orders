package com.ecom.order.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class OptionModel {

    @JsonProperty("idOption")
    private Long idOption;

    @JsonProperty("optionName")
    private String optionName;

    @JsonProperty("amountPercentage")
    private BigDecimal amountPercentage;

}
