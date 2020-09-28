package com.example.parking.controllers;

import com.example.parking.model.Client;

import com.example.parking.service.ClientService;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {

        this.clientService = clientService;
    }

    @PostMapping()
    public ResponseEntity<?> create( @RequestBody Client client)
    {
        return ResponseEntity.ok(clientService.createClient(client));
    }

    @GetMapping()
    public ResponseEntity<List<Client>> read()
    {
      return ResponseEntity.ok(clientService.readAllClients());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> read(@PathVariable UUID id) throws NotFoundException {
        return ResponseEntity.ok(clientService.readClient(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id) throws NotFoundException {
       clientService.deleteClient(id);
       return ResponseEntity.noContent().build();
    }


}
