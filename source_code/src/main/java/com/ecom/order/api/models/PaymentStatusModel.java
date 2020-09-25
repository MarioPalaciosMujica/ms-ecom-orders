package com.ecom.order.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentStatusModel {

    @JsonProperty("idPaymentStatus")
    private Long idPaymentStatus;

    @JsonProperty("statusName")
    private String statusName;

    @JsonProperty("responseCode")
    private String responseCode;

    @JsonProperty("isPaid")
    private boolean isPaid;

    @JsonProperty("paymentMethod")
    private PaymentMethodModel paymentMethod;

}
