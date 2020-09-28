package com.example.parking.controllers;

import com.example.parking.model.ParkingPlace;
import com.example.parking.service.ParkingPlaceService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/parkingplaces")
public class ParkingPlaceController {
    @Autowired
    private final ParkingPlaceService parkingPlaceService;

    public ParkingPlaceController(ParkingPlaceService parkingPlaceService) {
        this.parkingPlaceService = parkingPlaceService;
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody ParkingPlace parkingPlace) {
        return ResponseEntity.ok(parkingPlaceService.createParkingPlace(parkingPlace));
    }

    @GetMapping()
    public ResponseEntity<List<ParkingPlace>> read() {
        return ResponseEntity.ok(parkingPlaceService.readParkingPlaces());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ParkingPlace> read(@PathVariable(name = "id") int id) throws NotFoundException {
        return ResponseEntity.ok(parkingPlaceService.readParkingPlace(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id) throws NotFoundException {
       return ResponseEntity.ok(parkingPlaceService.updateParkingPlaceStatus(id));
    }


}
