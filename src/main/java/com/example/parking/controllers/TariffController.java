package com.example.parking.controllers;

import com.example.parking.model.Tariff;
import com.example.parking.service.TariffService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TariffController {
    @Autowired
    private final TariffService tariffService;

    public TariffController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @GetMapping(value = "/tariffs")
    public ResponseEntity<?> read(){
        return ResponseEntity.ok(tariffService.readAllTariff());
    }

    @GetMapping(value = "/tariffs/{id}")
    public ResponseEntity<?> read(@PathVariable(name = "id") int id) throws NotFoundException
    {
        return ResponseEntity.ok(tariffService.readTariff(id));
    }
    @PutMapping(value = "/tariffs/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, Tariff tariff) throws NotFoundException
    {
        return ResponseEntity.ok(tariffService.updateTariff(id,tariff));
    }


}
