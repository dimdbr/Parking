package com.example.parking.controllers;

import com.example.parking.model.CommunalWorker;
import com.example.parking.model.ParkingPlace;
import com.example.parking.service.CommunalWorkerService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommunalWorkerController {
    private final CommunalWorkerService communalWorkerService;

    public CommunalWorkerController(CommunalWorkerService communalWorkerService) {
        this.communalWorkerService = communalWorkerService;
    }

    @PostMapping(value = "/workers")
    public ResponseEntity<?> create(@RequestBody CommunalWorker communalWorker) {
        return ResponseEntity.ok(communalWorkerService.createCommunalWorker(communalWorker));
    }


    @GetMapping(value = "/workers")
    public ResponseEntity<List<CommunalWorker>> read() {
        return ResponseEntity.ok(communalWorkerService.readCommunalWorkers());
    }


    @GetMapping(value = "/workers/{id}")
    public ResponseEntity<CommunalWorker> read(@PathVariable(name = "id") String id)throws NotFoundException {
        return ResponseEntity.ok(communalWorkerService.readCommunalWorker(id));
    }

    @PutMapping(value = "/workers/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") String id, @RequestBody CommunalWorker communalWorker) throws NotFoundException {
        return ResponseEntity.ok(communalWorkerService.updateCommunalWorker(communalWorker,id));
    }
    @DeleteMapping(value = "/workers/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") String id) throws NotFoundException {
        communalWorkerService.deleteCommunalWorker(id);
        return ResponseEntity.noContent().build();
    }

}
