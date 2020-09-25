package com.ecom.order.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentMethodModel {

    @JsonProperty("idPaymentMethod")
    private Long idPaymentMethod;

    @JsonProperty("paymentMethodCode")
    private String paymentMethodCode;

    @JsonProperty("paymentMethodName")
    private String paymentMethodName;
}
