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

    @GetMapping(value = "/malf")
    public ResponseEntity<List<Malfunction>> read()
    {
        return ResponseEntity.ok(malfunctionService.readAllMalfunctions());

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
