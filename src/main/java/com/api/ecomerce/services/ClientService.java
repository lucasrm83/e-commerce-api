package com.api.ecomerce.services;

import com.api.ecomerce.entities.Client;
import com.api.ecomerce.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

}
