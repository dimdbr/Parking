package com.example.parking.service;

import com.example.parking.model.Contract;
import javassist.NotFoundException;

import java.util.List;

public interface ContractService {
    Contract createContract(Contract contract) throws NotFoundException;
    List<Contract> readAllContracts();
    Contract readContract(String id) throws NotFoundException;
    Contract addParkingPlace(String id, int parkingPlace) throws NotFoundException;
    Contract removeParkingPlace(String id, int parkingPlace) throws NotFoundException;

    Contract addClientCar(String id, String carName) throws NotFoundException;

    Contract removeClientCar(String id, String carName) throws NotFoundException;
    void deleteContract(String id)throws NotFoundException;
}
