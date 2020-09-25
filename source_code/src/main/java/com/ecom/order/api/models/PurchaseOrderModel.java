package com.ecom.order.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class PurchaseOrderModel {

    @JsonProperty("idPurchaseOrder")
    private Long idPurchaseOrder;

    @JsonProperty("code")
    private String code;

    @JsonProperty("idSession")
    private String idSession;

    @JsonProperty("idTransaction")
    private Long idTransaction;

    @JsonProperty("transactionDate")
    private String transactionDate;

    @JsonProperty("created")
    private String created;

    @JsonProperty("modified")
    private String modified;

    @JsonProperty("msUserAccountsIdAccount")
    private Long msUserAccountsIdAccount;

    @JsonProperty("purchaseOrderSummary")
    private PurchaseOrderSummaryModel purchaseOrderSummary;

    @JsonProperty("purchaseOrderStatus")
    private PurchaseOrderStatusModel purchaseOrderStatus;

    @JsonProperty("paymentStatus")
    private PaymentStatusModel paymentStatus;

    @JsonProperty("shipment")
    private ShipmentModel shipment;

    @JsonProperty("coupon")
    private CouponModel coupon;

    @JsonProperty("products")
    private List<ProductModel> products;

    @JsonProperty("taxes")
    private List<TaxModel> taxes;
}
