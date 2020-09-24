package com.example.parking.service;

import com.example.parking.model.Accountant;
import javassist.NotFoundException;

import java.util.List;

public interface ExpensesIncomeService {


    List<Accountant> readAllAccountants();
    Accountant readAccountant(int id) throws NotFoundException;
    Accountant updateSalary(int id,double salary) throws NotFoundException;
    void setPayPriceForClients() throws NotFoundException;

}
