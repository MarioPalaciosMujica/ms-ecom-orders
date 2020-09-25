package com.ecom.order.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ShipmentModel {

    @JsonProperty("idShipment")
    private Long idShipment;

    @JsonProperty("country")
    private String country;

    @JsonProperty("stateRegion")
    private String stateRegion;

    @JsonProperty("provinceCommune")
    private String provinceCommune;

    @JsonProperty("address")
    private String address;

    @JsonProperty("zipCode")
    private String zipCode;

    @JsonProperty("shipmentPriceAmount")
    private BigDecimal shipmentPriceAmount;

}
