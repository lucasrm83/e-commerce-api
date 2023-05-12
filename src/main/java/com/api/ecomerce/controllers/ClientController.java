package com.api.ecomerce.controllers;

import com.api.ecomerce.dto.ClientDto;
import com.api.ecomerce.entities.Client;
import com.api.ecomerce.services.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientController {

    final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Object> saveClient(Client client){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(client));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findClient(@PathVariable(value = "id") UUID id){
        Optional<Client> clientOptional =clientService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(clientOptional.get());

    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable(value = "id")UUID id,@RequestBody Client client) {
        Optional<Client> clientOptional = clientService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(clientService.save(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable(value = "id")UUID id) {
        Optional<Client> clientOptional = clientService.findById(id);
        clientService.delete(clientOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Client Deleted! ");
    }






}
