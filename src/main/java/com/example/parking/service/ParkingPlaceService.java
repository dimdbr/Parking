package com.example.parking.service;

import com.example.parking.model.ParkingPlace;
import javassist.NotFoundException;

import java.util.List;

public interface ParkingPlaceService {


    ParkingPlace createParkingPlace(ParkingPlace parkingPlace);

    List<ParkingPlace> readParkingPlaces();

    ParkingPlace readParkingPlace(int id) throws NotFoundException;

    ParkingPlace updateParkingPlaceStatus(int id) throws NotFoundException;
    List<ParkingPlace> readParkingPlacesByContractId(String contractId) throws NotFoundException;



    ParkingPlace addParkingPlaceToContract(String contractId, int id) throws NotFoundException;

    ParkingPlace removeParkingPlaceFromContract(String contractId, int id) throws NotFoundException;


}
