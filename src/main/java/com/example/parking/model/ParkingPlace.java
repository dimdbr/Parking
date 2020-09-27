package com.example.parking.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "parkingplaces")
public  final class ParkingPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int parkingPlaceId;
    @Column(name = "isoccupied")
    private boolean isOccupied =false;
    @Column (name = "contractid")
    private String contractId;
    public ParkingPlace(@JsonProperty("id") int parkingPlaceId,
                        @JsonProperty("isOccupied") boolean isOccupied) {
        this.parkingPlaceId = parkingPlaceId;
        this.isOccupied = isOccupied;
        this.contractId=null;
    }

    public ParkingPlace()
    {
        this.isOccupied = false;
    }
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getParkingPlaceId() {
        return parkingPlaceId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setParkingPlaceId(int parkingPlaceId) {
        this.parkingPlaceId = parkingPlaceId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public ParkingPlace changeStatus()
    {
        this.isOccupied = !this.isOccupied();
        return this;
    }
    public ParkingPlace addToContract(String contractId)
    {
        this.contractId=contractId;
        this.changeStatus();
        return this;
    }

    public ParkingPlace removeFromContract(String id)
    {
        if(this.contractId.equals(id.toString())) {
            this.contractId = null;
            this.changeStatus();
            return this;
        }
        return this;
    }

}
