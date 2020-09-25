package com.ecom.order.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tbl_purchase_order_statuses")
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purchase_order_status", updatable = false, nullable = false, unique = true)
    private Long idPurchaseOrderStatus;

    @Column(name = "status_code", nullable = false)
    @Size(max = 10)
    private String statusCode;

    @Column(name = "status_name", nullable = false, unique = true)
    @Size(min = 2, max = 50)
    private String statusName;

    @Column(name = "description")
    @Size(max = 255)
    private String description;

    @Column(name = "stage")
    private Integer stage;

    @Column(name = "is_updatable")
    private boolean isUpdatable;

    @OneToMany(mappedBy = "purchaseOrderStatus", fetch = FetchType.LAZY)
    private Set<PurchaseOrder> purchaseOrders;


    public Long getIdPurchaseOrderStatus() {
        return idPurchaseOrderStatus;
    }

    public void setIdPurchaseOrderStatus(Long idPurchaseOrderStatus) {
        this.idPurchaseOrderStatus = idPurchaseOrderStatus;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public boolean isUpdatable() {
        return isUpdatable;
    }

    public void setUpdatable(boolean updatable) {
        isUpdatable = updatable;
    }

    public Set<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(Set<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }
}
