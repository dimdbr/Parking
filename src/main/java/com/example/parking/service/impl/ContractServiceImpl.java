package com.example.parking.service.impl;

import com.example.parking.ParkingApplication;
import com.example.parking.model.Client;
import com.example.parking.model.Contract;
import com.example.parking.model.ParkingPlace;
import com.example.parking.repository.ClientRepository;
import com.example.parking.repository.ContractRepository;
import com.example.parking.repository.ParkingPlaceRepository;
import com.example.parking.service.ContractService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ParkingPlaceRepository parkingPlaceRepository;



    @Override
    public Contract createContract(Contract contract) throws NotFoundException {
        return contractRepository.save(contract);
    }

    @Override
    public List<Contract> readAllContracts() {
        return (List<Contract>) contractRepository.findAll();
    }

    @Override
    public Contract readContract(UUID id) throws NotFoundException {
        Optional<Contract> tempContr = contractRepository.findById(id);
        if(tempContr.isPresent())
            return contractRepository.findById(id).get();
        else
            throw new NotFoundException(String.format("Client with id %s dont exist",id));
    }

    @Override
    public Contract readByClientId(UUID clientId) throws NotFoundException {
        return contractRepository.findByClientId(clientId);
    }

    @Override
    public Contract addParkingPlace(UUID id, int parkingPlace) throws NotFoundException {
        Optional<ParkingPlace> tempPP = parkingPlaceRepository.
                findById(parkingPlace);
        if(tempPP.isPresent() && (tempPP.get().isOccupied()==false)) {
            parkingPlaceRepository.save(tempPP.
                    get().addToContract(id)
                    );
             return contractRepository.save(readContract(id));


        }
        throw new NotFoundException(String.format("Cant add this parking place to this contract"));
    }


    @Override
    public Contract removeParkingPlace(UUID id, int parkingPlace) throws NotFoundException {
        Optional<ParkingPlace> tempPP = parkingPlaceRepository.
                findById(parkingPlace);
        if(tempPP.isPresent() && (tempPP.get().isOccupied()==true)&&tempPP.get().getContractId().equals(id)) {
            parkingPlaceRepository.save(tempPP.
                    get().
                    removeFromContract(id));
            return contractRepository.save(readContract(id)); }
        throw new NotFoundException(String.format("Cant remove this parking place from this contract"));
    }

    @Override
    public Contract addClientCar(UUID id, String carName) throws NotFoundException {
        return contractRepository.save(readContract(id).addClientCar(carName));
    }

    @Override
    public Contract removeClientCar(UUID id, String carName) throws NotFoundException {
        return contractRepository.save(readContract(id).removeClientCar(carName));
    }

    @Override
    public void deleteContract(UUID id) throws NotFoundException {
        List<ParkingPlace> parkingPlaces= parkingPlaceRepository.findAll();
        for(ParkingPlace parkingPlace : parkingPlaces)
        {
            if(parkingPlace.getContractId()==id)
            {
                parkingPlace.changeStatus();
                parkingPlace.setContractId(null);
                parkingPlaceRepository.save(parkingPlace);
            }
        }
        contractRepository.delete(readContract(id));
    }
}
