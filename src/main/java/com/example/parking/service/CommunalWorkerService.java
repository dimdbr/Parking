package com.example.parking.service;

import com.example.parking.model.CommunalWorker;
import javassist.NotFoundException;

import java.util.List;

public interface CommunalWorkerService {

    CommunalWorker createCommunalWorker(CommunalWorker communalWorker);

    List<CommunalWorker> readCommunalWorkers();

    CommunalWorker readCommunalWorker(String id) throws NotFoundException;

    CommunalWorker updateCommunalWorker(CommunalWorker communalWorker, String id) throws NotFoundException;

    void deleteCommunalWorker(String id) throws NotFoundException;

}