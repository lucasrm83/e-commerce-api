package com.api.ecomerce.services;

import com.api.ecomerce.entities.Client;
import com.api.ecomerce.entities.Product;
import com.api.ecomerce.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {
    ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client save (Client client){
        return clientRepository.save(client);
    }
    public void delete(Client client){
        clientRepository.delete(client);
    }
    public Optional<Client> findById(UUID id) {
        return clientRepository.findById(id);
    }


}
