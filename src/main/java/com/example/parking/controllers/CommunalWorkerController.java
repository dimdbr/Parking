package com.example.parking.controllers;

import com.example.parking.model.CommunalWorker;
import com.example.parking.model.Malfunction;
import com.example.parking.service.CommunalWorkerService;
import com.example.parking.service.MalfunctionService;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommunalWorkerController {
    private final CommunalWorkerService communalWorkerService;
    private final MalfunctionService malfunctionService;

    public CommunalWorkerController(CommunalWorkerService communalWorkerService, MalfunctionService malfunctionService) {
        this.communalWorkerService = communalWorkerService;
        this.malfunctionService = malfunctionService;
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

    @PutMapping(value = "/workers/{id}/malf")
    public ResponseEntity<?> addMalfunction(@PathVariable(name = "id") String id,@RequestBody Malfunction malfunction) throws NotFoundException
    {
       return ResponseEntity.ok(communalWorkerService.addMalfunction(id,malfunction));
    }


    @DeleteMapping(value = "/workers/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") String id) throws NotFoundException {
        communalWorkerService.deleteCommunalWorker(id);
        return ResponseEntity.noContent().build();
    }

}
