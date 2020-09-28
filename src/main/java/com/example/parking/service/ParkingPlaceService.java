package com.example.parking.service;

import com.example.parking.model.ParkingPlace;
import javassist.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface ParkingPlaceService {


    ParkingPlace createParkingPlace(ParkingPlace parkingPlace);

    List<ParkingPlace> readParkingPlaces();

    ParkingPlace readParkingPlace(int id) throws NotFoundException;

    ParkingPlace updateParkingPlaceStatus(int id) throws NotFoundException;
    List<ParkingPlace> readParkingPlacesByContractId(UUID contractId) throws NotFoundException;



    ParkingPlace addParkingPlaceToContract(UUID contractId, int id) throws NotFoundException;

    ParkingPlace removeParkingPlaceFromContract(UUID contractId, int id) throws NotFoundException;


}
