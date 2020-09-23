package com.example.parking.service;

import com.example.parking.model.Malfunction;
import javassist.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface MalfunctionService {

    Malfunction createMalfunction(Malfunction malfunction);
    List<Malfunction> readAllMalfunctions();
    Malfunction readMalfunction(UUID id) throws NotFoundException;
    Malfunction addMalfunctionToWorker(String workerId,Malfunction malfunction) throws NotFoundException;

    void deleteMalfunction(UUID id) throws NotFoundException;
}
