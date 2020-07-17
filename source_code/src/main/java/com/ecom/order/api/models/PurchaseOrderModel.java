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

    @JsonProperty("isOrderPaid")
    private boolean isOrderPaid;

    @JsonProperty("created")
    private String created;

    @JsonProperty("modified")
    private Date modified;

    @JsonProperty("msUserAccountsIdAccount")
    private Long msUserAccountsIdAccount;

    @JsonProperty("purchaseOrderSummary")
    private PurchaseOrderSummaryModel purchaseOrderSummary;

    @JsonProperty("purchaseOrderStatus")
    private PurchaseOrderStatusModel purchaseOrderStatus;

    @JsonProperty("purchaseOrderCoupon")
    private PurchaseOrderCouponModel purchaseOrderCoupon;

    @JsonProperty("products")
    private List<ProductModel> products;

    @JsonProperty("purchaseOrderTaxes")
    private List<PurchaseOrderTaxModel> purchaseOrderTaxes;
}
