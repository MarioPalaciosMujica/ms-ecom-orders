package com.ecom.order.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class MaterialModel {

    @JsonProperty("idMaterial")
    private Long idMaterial;

    @JsonProperty("barcode")
    private String barcode;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("created")
    private Date created;

}
