package com.ecom.order.dalc.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tbl_purchase_order_statuses")
@NoArgsConstructor
public class PurchaseOrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purchase_order_status", updatable = false, nullable = false, unique = true)
    private Long idPurchaseOrderStatus;

    @Column(name = "status_name", nullable = false, unique = true)
    @Size(min = 2, max = 50)
    private String statusName;

    @Column(name = "description")
    @Size(max = 255)
    private String description;

    @Column(name = "stage", unique = true)
    private int stage;

    @Column(name = "created", nullable = false)
    private Date created;

    @Column(name = "modified")
    private Date modified;

    @OneToMany(mappedBy = "purchaseOrderStatus", fetch = FetchType.LAZY)
    private Set<PurchaseOrder> purchaseOrders;


    public Long getIdPurchaseOrderStatus() {
        return idPurchaseOrderStatus;
    }

    public void setIdPurchaseOrderStatus(Long idPurchaseOrderStatus) {
        this.idPurchaseOrderStatus = idPurchaseOrderStatus;
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

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Set<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(Set<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }
}
