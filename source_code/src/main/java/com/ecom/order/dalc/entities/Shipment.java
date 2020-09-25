package com.ecom.order.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "tbl_shipments")
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shipment", updatable = false, nullable = false, unique = true)
    private Long idShipment;

    @Column(name = "country")
    @Size(max = 50)
    private String country;

    @Column(name = "state_region")
    @Size(max = 50)
    private String stateRegion;

    @Column(name = "province_commune")
    @Size(max = 50)
    private String provinceCommune;

    @Column(name = "address")
    @Size(max = 255)
    private String address;

    @Column(name = "zip_code")
    @Size(max = 50)
    private String zipCode;

    @Column(name = "shipment_price_amount")
    private BigDecimal shipmentPriceAmount;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "shipment")
    private PurchaseOrder purchaseOrder;


    public Long getIdShipment() {
        return idShipment;
    }

    public void setIdShipment(Long idShipment) {
        this.idShipment = idShipment;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStateRegion() {
        return stateRegion;
    }

    public void setStateRegion(String stateRegion) {
        this.stateRegion = stateRegion;
    }

    public String getProvinceCommune() {
        return provinceCommune;
    }

    public void setProvinceCommune(String provinceCommune) {
        this.provinceCommune = provinceCommune;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public BigDecimal getShipmentPriceAmount() {
        return shipmentPriceAmount;
    }

    public void setShipmentPriceAmount(BigDecimal shipmentPriceAmount) {
        this.shipmentPriceAmount = shipmentPriceAmount;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
}
