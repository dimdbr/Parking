package com.example.parking.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "malfunctions")
public final class Malfunction {

    @Id
    @Column(name = "id",updatable = false, nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    //"org.hibernate.id.UUIDGenerator"
    private UUID malfunctionId;
    @Column(name = "fixprice")
    private double fixPrice;
    @Column(name = "malfname")
    private String malfunctionDesc;
    @Column(name = "ispayed")
    private boolean isPayed;
    @Column(name = "workerid")
    private String workerId;



    public Malfunction(UUID malfunctionId, double fixPrice, String malfunctionDesc, boolean isPayed, String workerId) {
        this.malfunctionId = malfunctionId;
        this.fixPrice = fixPrice;
        this.malfunctionDesc = malfunctionDesc;
        this.isPayed = isPayed;
        this.workerId = workerId;
    }
    public Malfunction( double fixPrice, String malfunctionDesc) {
        this.malfunctionId = UUID.randomUUID();
        this.fixPrice = fixPrice;
        this.malfunctionDesc = malfunctionDesc;
        this.isPayed = false;


    }

    public Malfunction() {

    }

    public UUID getMalfunctionId() {
        return malfunctionId;
    }

    public double getFixPrice() {
        return fixPrice;
    }

    public String getMalfunctionDesc() {
        return malfunctionDesc;
    }

    public void setMalfunctionId(UUID malfunctionId) {
        this.malfunctionId = malfunctionId;
    }

    public void setFixPrice(double fixPrice) {
        this.fixPrice = fixPrice;
    }

    public void setMalfunctionDesc(String malfunctionDesc) {
        this.malfunctionDesc = malfunctionDesc;
    }

    public Malfunction addToWorker(String workerId)
    {
        this.workerId=workerId;
        return this;
    }


}
