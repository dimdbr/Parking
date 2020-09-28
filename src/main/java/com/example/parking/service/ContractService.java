package com.example.parking.service;

import com.example.parking.model.Contract;
import javassist.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface ContractService {
    Contract createContract(Contract contract) throws NotFoundException;
    List<Contract> readAllContracts();
    Contract readContract(UUID id) throws NotFoundException;
    Contract readByClientId(UUID clientId) throws NotFoundException;
    Contract addParkingPlace(UUID id, int parkingPlace) throws NotFoundException;
    Contract removeParkingPlace(UUID id, int parkingPlace) throws NotFoundException;

    Contract addClientCar(UUID id, String carName) throws NotFoundException;

    Contract removeClientCar(UUID id, String carName) throws NotFoundException;
    void deleteContract(UUID id)throws NotFoundException;
}
