package com.example.parking.service.impl;

import com.example.parking.model.Client;
import com.example.parking.model.Malfunction;
import com.example.parking.repository.MalfunctionRepository;
import com.example.parking.service.MalfunctionService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MalfunctionServiceImpl implements MalfunctionService {

    @Autowired
    private MalfunctionRepository malfunctionRepository;

    NamedParameterJdbcTemplate template;

    @Override
    public Malfunction createMalfunction(Malfunction malfunction) {
        return malfunctionRepository.save(malfunction);
    }


    @Override
    public List<Malfunction> readPayedMalfunctions()
    {
         return malfunctionRepository.readUnpayed();
    }

    @Override
    public List<Malfunction> readUnPayedMalfunctions() {
        return malfunctionRepository.readPayed();
    }


    @Override
    public Malfunction readMalfunction(UUID id) throws NotFoundException {
        Optional<Malfunction> tempMalfunction =malfunctionRepository.findById(id);
        if(tempMalfunction.isPresent())
            return malfunctionRepository.findById(id).get();
        else
            throw new NotFoundException(String.format("Client with id %s dont exist",id));
    }

    @Override
    public Malfunction addMalfunctionToWorker(String workerId, Malfunction malfunction) throws NotFoundException {
        return malfunctionRepository.save(malfunction.addToWorker(workerId));
    }

    @Override
    public void deleteMalfunction(UUID id) throws NotFoundException {
        malfunctionRepository.delete(readMalfunction(id));

    }
}
