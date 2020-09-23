package com.example.parking.model;

import javax.persistence.*;

@Entity
@Table(name = "tariffs")
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int tariffId;
    @Column(name = "parkingprice")
    private double placePrice;
    @Column(name = "watertariff")
    private  double waterTariff;
    @Column(name = "electricitytariff")
    private  double electricityTariff;
    @Column(name = "gastariff")
    private  double gasTariff;
    @Column(name = "tariffdesc")
    private String tariffDesc;
    public Tariff(double placePrice, double waterTariff, double electricityTariff, double gasTariff, String tariffDesc) {

        this.placePrice = placePrice;
        this.waterTariff = waterTariff;
        this.electricityTariff = electricityTariff;
        this.gasTariff = gasTariff;
        this.tariffDesc = tariffDesc;
    }

    public Tariff()
    {

    }

    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    public int getTariffId() {
        return tariffId;
    }

    public double getPlacePrice() {
        return placePrice;
    }

    public double getWaterTariff() {
        return waterTariff;
    }

    public String getTariffDesc() {
        return tariffDesc;
    }

    public void setTariffDesc(String tariffDesc) {
        this.tariffDesc = tariffDesc;
    }

    public double getElectricityTariff() {
        return electricityTariff;
    }

    public double getGasTariff() {
        return gasTariff;
    }

    public void setPlacePrice(double placePrice) {
        this.placePrice = placePrice;
    }

    public void setWaterTariff(double waterTariff) {
        this.waterTariff = waterTariff;
    }

    public void setElectricityTariff(double electricityTariff) {
        this.electricityTariff = electricityTariff;
    }

    public void setGasTariff(double gasTariff) {
        this.gasTariff = gasTariff;
    }


}
