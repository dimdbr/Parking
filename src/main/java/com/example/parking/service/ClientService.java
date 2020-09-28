package com.example.parking.service;

import com.example.parking.model.Client;
import com.example.parking.model.ParkingPlace;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientService {

    Client createClient( Client client);


    List<Client> readAllClients();

     Client readClient(UUID Id) throws NotFoundException;

     Client updateClientPayPrice(UUID id,double price) throws NotFoundException;

     void deleteClient(UUID id) throws NotFoundException;



}
