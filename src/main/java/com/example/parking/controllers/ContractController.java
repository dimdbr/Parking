package com.example.parking.controllers;

import com.example.parking.model.Contract;
import com.example.parking.service.ContractService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContractController {
    @Autowired
    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping(value ="/contracts")
    public ResponseEntity<?> create (@RequestBody Contract contract) throws NotFoundException
    {

        return ResponseEntity.ok(contractService.createContract(contract));
    }

    @GetMapping(value = "/contracts")
    public ResponseEntity<?> read()
    {
        return ResponseEntity.ok(contractService.readAllContracts());
    }

    @GetMapping(value = "/contracts/{id}")
    public ResponseEntity<?> read(@PathVariable String id) throws NotFoundException
    {
        return ResponseEntity.ok(contractService.readContract(id));
    }
    @GetMapping(value = "/contracts/findbyclient/{clientid}")
    public ResponseEntity<?> readByClientId(@PathVariable String clientid) throws NotFoundException
    {
        return ResponseEntity.ok(contractService.readByClientId(clientid));
    }
    @DeleteMapping(value = "/contracts/{id}")
    public ResponseEntity<?> delete(@PathVariable String id)  throws NotFoundException
    {
        contractService.deleteContract(id);
        return ResponseEntity.noContent().build();
    }



    @PutMapping(value = "contracts/{id}/addcar/{carname}")
    public ResponseEntity<?> addCar(@PathVariable String id,@PathVariable String carname) throws NotFoundException
    {
        return ResponseEntity.ok(contractService.addClientCar(id,carname));
    }

    @PutMapping(value = "contracts/{id}/delcar/{carname}")
    public ResponseEntity<?> removeCar(@PathVariable String id,@PathVariable String carname) throws NotFoundException
    {
        return ResponseEntity.ok(contractService.removeClientCar(id,carname));
    }

    @PutMapping(value = "contracts/{id}/addparkplace/{parkingplaceid}")
    public ResponseEntity<?> addParkPlace(@PathVariable String id, @PathVariable int parkingplaceid)  throws NotFoundException
    {
        return ResponseEntity.ok(contractService.addParkingPlace(id,parkingplaceid));
    }
    @PutMapping(value = "contracts/{id}/removeparkplace/{parkingplaceid}")
    public ResponseEntity<?> removeParkPlace(@PathVariable String id, @PathVariable int parkingplaceid)  throws NotFoundException
    {
        return ResponseEntity.ok(contractService.removeParkingPlace(id,parkingplaceid));
    }

}
