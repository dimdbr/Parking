package com.example.parking.service.impl;

import com.example.parking.model.ParkingPlace;
import com.example.parking.repository.ParkingPlaceRepository;
import com.example.parking.service.ParkingPlaceService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ParkingPlaceServiceImpl implements ParkingPlaceService {

   @Autowired
   private ParkingPlaceRepository parkingPlaceRepository;

    @Override
    public ParkingPlace createParkingPlace(ParkingPlace parkingPlace) {
        return parkingPlaceRepository.save(parkingPlace);
    }

    @Override
    public List<ParkingPlace> readParkingPlaces() {
        return new ArrayList<>(parkingPlaceRepository.findAll());
    }

    @Override
    public ParkingPlace readParkingPlace(int id) throws NotFoundException {
        Optional<ParkingPlace> tempPP = parkingPlaceRepository.findById(id);
        if(tempPP.isPresent())
        {
            return parkingPlaceRepository.findById(id).get();
        }
        else throw new NotFoundException(String.format("ParkingPlace with id % dont exist",id));
    }

    @Override
    public ParkingPlace updateParkingPlaceStatus(int id) throws NotFoundException
    {
        return parkingPlaceRepository.save(readParkingPlace(id).changeStatus());
    }

    @Override
    public ParkingPlace addParkingPlaceToContract(String contractId,int id) throws NotFoundException{
        return parkingPlaceRepository.save(readParkingPlace(id).addToContract(contractId));
    }

    @Override
    public ParkingPlace removeParkingPlaceFromContract(String contractId, int id) throws NotFoundException {
        return parkingPlaceRepository.save(readParkingPlace(id).removeFromContract(contractId));
    }


}
