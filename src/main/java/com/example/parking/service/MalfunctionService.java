package com.example.parking.service;

import com.example.parking.model.Malfunction;
import javassist.NotFoundException;

import java.util.List;

public interface MalfunctionService {

    Malfunction createMalfunction(Malfunction malfunction);
    List<Malfunction> readAllMalfunctions();
    Malfunction readMalfunction(String id) throws NotFoundException;
    void deleteMalfunction(String id) throws NotFoundException;
}
