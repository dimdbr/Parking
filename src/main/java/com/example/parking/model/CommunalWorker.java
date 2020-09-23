package com.example.parking.model;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "workers")
public final  class CommunalWorker {
    @Id
    @Column(name = "id",updatable = false, nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String cwId;
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private double salary;
    @Column(name ="cwtype")
    @Enumerated(EnumType.STRING)
    private CW_Type cwType;
    @Column(name = "iswinter")
    private boolean isWinter;


    public CommunalWorker(String cwId, String name, double salary, CW_Type cwType, boolean isWinter, String malfunctionId) {
        this.cwId = cwId;
        this.name = name;
        this.salary = salary;
        this.cwType = cwType;
        this.isWinter = isWinter;

    }

    public CommunalWorker(String name, double salary, CW_Type cwType, boolean isWinter) {
        this.cwId = UUID.randomUUID().toString();
        this.name = name;
        this.salary = salary;
        this.cwType = cwType;
        this.isWinter = isWinter;

    }

    public CommunalWorker() {

    }

    public String getCwId() {
        return cwId;
    }

    public void setCwId(String cwId) {
        this.cwId = cwId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public CW_Type getCwType() {
        return cwType;
    }

    public void setCwType(CW_Type cwType) {
        this.cwType = cwType;
    }

    public boolean isWinter() {
        return isWinter;
    }

    public void setWinter(boolean winter) {
        isWinter = winter;
    }



}
