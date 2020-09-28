package com.example.parking.service;

import com.example.parking.model.Malfunction;
import javassist.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface MalfunctionService {

    Malfunction createMalfunction(Malfunction malfunction);
    List<Malfunction> readMalfunctions(boolean ispayed);
    Malfunction readMalfunction(UUID id) throws NotFoundException;
    Malfunction addMalfunctionToWorker(UUID workerId,Malfunction malfunction) throws NotFoundException;

    void deleteMalfunction(UUID id) throws NotFoundException;
}
