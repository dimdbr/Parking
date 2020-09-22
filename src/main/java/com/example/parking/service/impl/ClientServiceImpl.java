package com.example.parking.service.impl;

import com.example.parking.model.Client;
import com.example.parking.model.ParkingPlace;
import com.example.parking.repository.ClientRepository;
import com.example.parking.service.ClientService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client clientForSave) {
        return clientRepository.save(clientForSave);
    }



    @Override
    public List<Client> readAllClients() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Client readClient(String id) throws NotFoundException {
        Optional<Client> tempClient = clientRepository.findById(id);
        if(tempClient.isPresent())
            return clientRepository.findById(id).get();
        else
            throw new NotFoundException(String.format("Client with id %s dont exist",id));
    }

    @Override
    public  Client updateClientPayPrice(String id, double payPrice) throws NotFoundException{

        return clientRepository.save(readClient(id).setMonthPay(payPrice));
    }
    @Override
    public void deleteClient(String id) throws NotFoundException {
        clientRepository.delete(readClient(id));
    }


}
