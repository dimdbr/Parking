package com.example.parking.controllers;

import com.example.parking.model.CommunalWorker;
import com.example.parking.model.Malfunction;
import com.example.parking.service.CommunalWorkerService;
import com.example.parking.service.MalfunctionService;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/workers")
public class CommunalWorkerController {
    private final CommunalWorkerService communalWorkerService;
    private final MalfunctionService malfunctionService;

    public CommunalWorkerController(CommunalWorkerService communalWorkerService, MalfunctionService malfunctionService) {
        this.communalWorkerService = communalWorkerService;
        this.malfunctionService = malfunctionService;
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CommunalWorker communalWorker) {
        return ResponseEntity.ok(communalWorkerService.createCommunalWorker(communalWorker));
    }


    @GetMapping()
    public ResponseEntity<List<CommunalWorker>> read() {
        return ResponseEntity.ok(communalWorkerService.readCommunalWorkers());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<CommunalWorker> read(@PathVariable(name = "id") UUID id)throws NotFoundException {
        return ResponseEntity.ok(communalWorkerService.readCommunalWorker(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") UUID id, @RequestBody CommunalWorker communalWorker) throws NotFoundException {
        return ResponseEntity.ok(communalWorkerService.updateCommunalWorker(communalWorker,id));
    }

    @PutMapping(value = "/{id}/malfunctions")
    public ResponseEntity<?> addMalfunction(@PathVariable(name = "id") UUID id,@RequestBody Malfunction malfunction) throws NotFoundException
    {
       return ResponseEntity.ok(communalWorkerService.addMalfunction(id,malfunction));
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id) throws NotFoundException {
        communalWorkerService.deleteCommunalWorker(id);
        return ResponseEntity.noContent().build();
    }

}
