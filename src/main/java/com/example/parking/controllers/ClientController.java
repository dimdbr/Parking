package com.example.parking.controllers;

import com.example.parking.model.Client;

import com.example.parking.service.ClientService;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/clients")
    public ResponseEntity<?> create( @RequestBody Client client)
    {
        return ResponseEntity.ok(clientService.createClient(client));
    }

    @GetMapping(value = "/clients")
    public ResponseEntity<List<Client>> read()
    {
      return ResponseEntity.ok(clientService.readAllClients());
    }

    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<Client> read(@PathVariable String id) throws NotFoundException {
        return ResponseEntity.ok(clientService.readClient(id));
    }

    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") String id, @RequestBody double payPrice) throws NotFoundException{
        return ResponseEntity.ok(clientService.updateClientPayPrice(id,payPrice));
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") String id) throws NotFoundException {
       clientService.deleteClient(id);
       return ResponseEntity.noContent().build();
    }


}
