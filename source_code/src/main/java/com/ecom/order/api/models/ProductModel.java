package com.ecom.order.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class ProductModel {

    @JsonProperty("idProduct")
    private Long idProduct;

    @JsonProperty("barcode")
    private String barcode;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("isSale")
    private boolean isSale;

    @JsonProperty("discountPercentage")
    private BigDecimal discountPercentage;

    @JsonProperty("currentBasePrice")
    private BigDecimal currentBasePrice;

    @JsonProperty("currentTotalPrice")
    private BigDecimal currentTotalPrice;

    @JsonProperty("isCapacityQty")
    private boolean isCapacityQty;

    @JsonProperty("images")
    private List<ImageModel> images;

    @JsonProperty("imageSrc")
    private String imageSrc;

    @JsonProperty("msProductIdProduct")
    private Long msProductIdProduct;

    @JsonProperty("variants")
    private List<VariantModel> variants;

    @JsonProperty("variant")
    private VariantModel variant;


}
