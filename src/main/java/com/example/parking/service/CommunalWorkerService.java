package com.example.parking.service;

import com.example.parking.model.CommunalWorker;
import com.example.parking.model.Malfunction;
import javassist.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface CommunalWorkerService {

    CommunalWorker createCommunalWorker(CommunalWorker communalWorker);

    List<CommunalWorker> readCommunalWorkers();

    CommunalWorker readCommunalWorker(UUID id) throws NotFoundException;

    CommunalWorker updateCommunalWorker(CommunalWorker communalWorker, UUID id) throws NotFoundException;

    CommunalWorker addMalfunction(UUID id, Malfunction malfunction) throws NotFoundException;
    void deleteCommunalWorker(UUID id) throws NotFoundException;

}
