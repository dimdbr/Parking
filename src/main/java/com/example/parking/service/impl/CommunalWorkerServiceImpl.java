package com.example.parking.service.impl;

import com.example.parking.model.CommunalWorker;
import com.example.parking.model.Malfunction;
import com.example.parking.model.ParkingPlace;
import com.example.parking.repository.CommunalWorkerRepository;
import com.example.parking.repository.MalfunctionRepository;
import com.example.parking.service.CommunalWorkerService;
import com.fasterxml.jackson.annotation.JsonValue;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CommunalWorkerServiceImpl implements CommunalWorkerService {

    @Autowired
    private CommunalWorkerRepository communalWorkerRepository;
    @Autowired
    private MalfunctionRepository malfunctionRepository;
    //private static final Map<Integer, CommunalWorker> COM_WORKER_PLACE_MAP = new HashMap<>();

    // Переменная для генерации ID клиента
    //private static final AtomicInteger WORKER_ID = new AtomicInteger();

    @Override
    public CommunalWorker createCommunalWorker( CommunalWorker communalWorker) {
     return communalWorkerRepository.save(communalWorker);
    }

    @Override
    public List<CommunalWorker> readCommunalWorkers() {
        return communalWorkerRepository.findAll();
    }

    @Override
    public CommunalWorker readCommunalWorker(UUID id) throws NotFoundException {
        Optional<CommunalWorker> tempComWork = communalWorkerRepository.findById(id);
        if(tempComWork.isPresent())
            return communalWorkerRepository.findById(id).get();
        else
            throw new NotFoundException(String.format("Worker with id %s dont exist",id));
    }

    @Override
    public CommunalWorker updateCommunalWorker(CommunalWorker communalWorker, UUID id) throws NotFoundException {
        if(communalWorkerRepository.existsById(id))

            communalWorker.setCwId(id);
        return communalWorkerRepository.save(communalWorker);

    }

    @Override
    public CommunalWorker addMalfunction(UUID id, Malfunction malfunction) throws NotFoundException {

        malfunction.addToWorker(id);
        malfunctionRepository.save(malfunction);
        return communalWorkerRepository.save(readCommunalWorker(id));
    }

    @Override
    public void deleteCommunalWorker(UUID id) throws NotFoundException{
        communalWorkerRepository.delete(readCommunalWorker(id));
    }
}
