package com.example.parking.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "malfunctions")
public final class Malfunction {

    @Id
    @Column(name = "id",updatable = false, nullable = false)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String malfunctionId;
    @Column(name = "fixPrice")
    private double fixPrice;
    @Column(name = "malfunctionDesc")
    private String malfunctionDesc;


    public Malfunction(String malfunctionId, double fixPrice, String malfunctionDesc) {
        this.malfunctionId = malfunctionId;
        this.fixPrice = fixPrice;
        this.malfunctionDesc = malfunctionDesc;
    }

    public Malfunction() {

    }

    public String getMalfunctionId() {
        return malfunctionId;
    }

    public double getFixPrice() {
        return fixPrice;
    }

    public String getMalfunctionDesc() {
        return malfunctionDesc;
    }

    public void setMalfunctionId(String malfunctionId) {
        this.malfunctionId = malfunctionId;
    }

    public void setFixPrice(double fixPrice) {
        this.fixPrice = fixPrice;
    }

    public void setMalfunctionDesc(String malfunctionDesc) {
        this.malfunctionDesc = malfunctionDesc;
    }


}
