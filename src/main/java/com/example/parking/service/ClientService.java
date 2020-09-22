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

     Client readClient(String Id) throws NotFoundException;

     Client updateClientPayPrice(String id,double price) throws NotFoundException;

     void deleteClient(String id) throws NotFoundException;



}
