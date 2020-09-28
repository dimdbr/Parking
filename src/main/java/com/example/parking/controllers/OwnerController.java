package com.example.parking.controllers;

import com.example.parking.model.CoOwner;
import com.example.parking.model.Tariff;
import com.example.parking.service.CoOwnerService;
import com.example.parking.service.TariffService;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/owners")
public class OwnerController {

    private final CoOwnerService coOwnerService;
    private final TariffService tariffService;

    public OwnerController(CoOwnerService coOwnerService, TariffService tariffService) {
        this.coOwnerService = coOwnerService;
        this.tariffService = tariffService;
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CoOwner coOwner)
    {
        return ResponseEntity.ok(coOwnerService.createOwner(coOwner));
    }

    @GetMapping()
    public ResponseEntity<?> read()
    {
        return ResponseEntity.ok(coOwnerService.readCoOwner());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> read(@PathVariable(name = "id") int id) throws NotFoundException
    {
        return ResponseEntity.ok(coOwnerService.readCoOwner(id));
    }


    @PutMapping(value = "/changetariff/{id}")
    public ResponseEntity<?> updateTariff(@PathVariable(name = "id") int tariffid,@RequestBody Tariff tariff) throws NotFoundException
    {
        return ResponseEntity.ok(tariffService.updateTariff(tariffid,tariff));
    }

    @PutMapping(value = "/{id}/collectmoney")
    public ResponseEntity<?> collectMoney(@PathVariable(name = "id") int id) throws NotFoundException
    {
        return ResponseEntity.ok(coOwnerService.collectMoney(id));
    }

    @PutMapping(value = "/paymoney")
    public ResponseEntity<?> payMoney() throws NotFoundException
    {
        coOwnerService.payMoney();

        return ResponseEntity.noContent().build();
    }
}