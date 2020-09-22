package com.example.parking.service;

import com.example.parking.model.ParkingPlace;
import javassist.NotFoundException;

import java.util.List;

public interface ParkingPlaceService {


    ParkingPlace createParkingPlace(ParkingPlace parkingPlace);

    List<ParkingPlace> readParkingPlaces();

    ParkingPlace readParkingPlace(int id) throws NotFoundException;

    ParkingPlace updateParkingPlaceStatus(int id) throws NotFoundException;



}