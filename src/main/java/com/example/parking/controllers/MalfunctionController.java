package com.example.parking.controllers;

import com.example.parking.model.Client;
import com.example.parking.model.Malfunction;
import com.example.parking.service.MalfunctionService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class MalfunctionController {

    private final MalfunctionService malfunctionService;
    @Autowired

    public MalfunctionController(MalfunctionService malfunctionService) {
        this.malfunctionService = malfunctionService;
    }


    @PostMapping(value = "/malf")
    public ResponseEntity<?> create(@RequestBody Malfunction malfunction)
    {
        return ResponseEntity.ok(malfunctionService.createMalfunction(malfunction));

    }

    @GetMapping(value = "/malf/p")
    public ResponseEntity<List<Malfunction>> readPayed()
    {
        return ResponseEntity.ok(malfunctionService.readPayedMalfunctions());

    }

    @GetMapping(value = "/malf/up")
    public ResponseEntity<List<Malfunction>> readUnPayed()
    {
        return ResponseEntity.ok(malfunctionService.readUnPayedMalfunctions());

    }
    @GetMapping(value = "/malf/{id}")
    public ResponseEntity<Malfunction> read(@PathVariable UUID id) throws NotFoundException {
        return ResponseEntity.ok(malfunctionService.readMalfunction(id));
    }

    @DeleteMapping(value = "/malf/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id) throws NotFoundException {
        malfunctionService.deleteMalfunction(id);
        return ResponseEntity.noContent().build();
    }
}
