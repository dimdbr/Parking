package com.example.parking.controllers;

import com.example.parking.model.Contract;
import com.example.parking.service.ContractService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/contracts")
public class ContractController {
    @Autowired
    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping()
    public ResponseEntity<?> create (@RequestBody Contract contract) throws NotFoundException
    {

        return ResponseEntity.ok(contractService.createContract(contract));
    }

    @GetMapping()
    public ResponseEntity<?> read()
    {
        return ResponseEntity.ok(contractService.readAllContracts());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> read(@PathVariable UUID id) throws NotFoundException
    {
        return ResponseEntity.ok(contractService.readContract(id));
    }
    @GetMapping(value = "/findbyclient/{clientid}")
    public ResponseEntity<?> readByClientId(@PathVariable UUID clientid) throws NotFoundException
    {
        return ResponseEntity.ok(contractService.readByClientId(clientid));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id)  throws NotFoundException
    {
        contractService.deleteContract(id);
        return ResponseEntity.noContent().build();
    }



    @PutMapping(value = "/{id}/addcar/{carname}")
    public ResponseEntity<?> addCar(@PathVariable UUID id,@PathVariable String carname) throws NotFoundException
    {
        return ResponseEntity.ok(contractService.addClientCar(id,carname));
    }

    @PutMapping(value = "/{id}/delcar/{carname}")
    public ResponseEntity<?> removeCar(@PathVariable UUID id,@PathVariable String carname) throws NotFoundException
    {
        return ResponseEntity.ok(contractService.removeClientCar(id,carname));
    }

    @PutMapping(value = "/{id}/addparkplace/{parkingplaceid}")
    public ResponseEntity<?> addParkPlace(@PathVariable UUID id, @PathVariable int parkingplaceid)  throws NotFoundException
    {
        return ResponseEntity.ok(contractService.addParkingPlace(id,parkingplaceid));
    }
    @PutMapping(value = "/{id}/removeparkplace/{parkingplaceid}")
    public ResponseEntity<?> removeParkPlace(@PathVariable UUID id, @PathVariable int parkingplaceid)  throws NotFoundException
    {
        return ResponseEntity.ok(contractService.removeParkingPlace(id,parkingplaceid));
    }

}
