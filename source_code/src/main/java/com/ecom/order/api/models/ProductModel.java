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

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("qty")
    private int qty;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("image")
    private ImageModel image;

    @JsonProperty("urlImage")
    private String urlImage;

    @JsonProperty("msProductIdProduct")
    private Long msProductIdProduct;

    @JsonProperty("productDiscounts")
    private List<ProductDiscountModel> productDiscounts;

    @JsonProperty("productTaxes")
    private List<ProductTaxModel> productTaxes;

    @JsonProperty("materials")
    private List<MaterialModel> materials;
}
