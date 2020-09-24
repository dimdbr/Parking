package com.example.parking.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="accountants")
public class Accountant {
    @Id
    @Column(name = "id",updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountantId;
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private double salary;

    public Accountant(int accountantId, String name, double salary) {
        this.accountantId = accountantId;
        this.name = name;
        this.salary = salary;
    }

    public Accountant(String name, double salary) {

        this.name = name;
        this.salary = salary;
    }

    public Accountant() {

    }

    public String getName() {
        return name;
    }

    public int getAccountantId() {
        return accountantId;
    }

    public void setAccountantId(int accountantId) {
        this.accountantId = accountantId;
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
}
