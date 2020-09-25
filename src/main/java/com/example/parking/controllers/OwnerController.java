package com.example.parking.controllers;

import com.example.parking.model.Tariff;
import com.example.parking.service.CoOwnerService;
import com.example.parking.service.TariffService;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OwnerController {

    private final CoOwnerService coOwnerService;
    private final TariffService tariffService;

    public OwnerController(CoOwnerService coOwnerService, TariffService tariffService) {
        this.coOwnerService = coOwnerService;
        this.tariffService = tariffService;
    }

    @GetMapping(value = "/owners")
    public ResponseEntity<?> read()
    {
        return ResponseEntity.ok(coOwnerService.readCoOwner());
    }

    @GetMapping(value = "/owners/{id}")
    public ResponseEntity<?> read(@PathVariable(name = "id") int id) throws NotFoundException
    {
        return ResponseEntity.ok(coOwnerService.readCoOwner(id));
    }


    @PutMapping(value = "/owners/changetariff/{id}")
    public ResponseEntity<?> updateTariff(@PathVariable(name = "id") int tariffid,@RequestBody Tariff tariff) throws NotFoundException
    {
        return ResponseEntity.ok(tariffService.updateTariff(tariffid,tariff));
    }

    @PutMapping(value = "/owners/{id}/collectmoney")
    public ResponseEntity<?> collectMoney(@PathVariable(name = "id") int id) throws NotFoundException
    {
        return ResponseEntity.ok(coOwnerService.collectMoney(id));
    }

    @PutMapping(value = "/owners/paymoney")
    public ResponseEntity<?> payMoney() throws NotFoundException
    {
        coOwnerService.payMoney();

        return ResponseEntity.noContent().build();
    }
}