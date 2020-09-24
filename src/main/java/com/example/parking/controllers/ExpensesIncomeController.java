package com.example.parking.controllers;

import com.example.parking.service.ExpensesIncomeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExpensesIncomeController {

    @Autowired
    private final ExpensesIncomeService expensesIncomeService;

    public ExpensesIncomeController(ExpensesIncomeService expensesIncomeService) {
        this.expensesIncomeService = expensesIncomeService;
    }
    @GetMapping(value = "/accountants")
    public ResponseEntity<?> read()
    {
        return ResponseEntity.ok(expensesIncomeService.readAllAccountants());
    }

    @GetMapping(value = "/accountants/{id}")
    public ResponseEntity<?> read(@PathVariable int id)  throws NotFoundException
    {
        return ResponseEntity.ok(expensesIncomeService.readAccountant(id));
    }


    @PutMapping(value = "/accountants/{id}")
    public ResponseEntity<?> updateAccountantSalary(@PathVariable int id, @RequestBody double newSalary)  throws NotFoundException
    {
        return ResponseEntity.ok(expensesIncomeService.updateSalary(id,newSalary));
    }

    @PutMapping(value = "/accountants/setprice")
    public ResponseEntity<?> updatePayPriceForClients() throws NotFoundException
    {
       expensesIncomeService.setPayPriceForClients();
       return ResponseEntity.noContent().build();
    }
}
