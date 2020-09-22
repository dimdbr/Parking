package com.example.parking.service.impl;

import com.example.parking.model.Client;
import com.example.parking.model.Malfunction;
import com.example.parking.repository.MalfunctionRepository;
import com.example.parking.service.MalfunctionService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MalfunctionServiceImpl implements MalfunctionService {

    @Autowired
    private MalfunctionRepository malfunctionRepository;


    @Override
    public Malfunction createMalfunction(Malfunction malfunction) {
        return malfunctionRepository.save(malfunction);
    }

    @Override
    public List<Malfunction> readAllMalfunctions() {
        return (List<Malfunction>) malfunctionRepository.findAll();
    }

    @Override
    public Malfunction readMalfunction(String id) throws NotFoundException {
        Optional<Malfunction> tempMalfunction =malfunctionRepository.findById(id);
        if(tempMalfunction.isPresent())
            return malfunctionRepository.findById(id).get();
        else
            throw new NotFoundException(String.format("Client with id %s dont exist",id));
    }

    @Override
    public void deleteMalfunction(String id) throws NotFoundException {
        malfunctionRepository.delete(readMalfunction(id));

    }
}
