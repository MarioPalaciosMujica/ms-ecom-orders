package com.ecom.order.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ImageModel {

    @JsonProperty("idImage")
    private Long idImage;

    @JsonProperty("name")
    private String name;

    @JsonProperty("urlImage")
    private String urlImage;

}
