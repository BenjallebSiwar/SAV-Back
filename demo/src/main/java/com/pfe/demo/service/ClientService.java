package com.pfe.demo.service;

import com.pfe.demo.entity.Client;
import com.pfe.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClientService {





     Client saveClient(Client client) ;
    List<Client> getAllClients();

    Client getClientById(Long clientId);

    Client updateClient(Client client);

    void deleteClient(Long clientId);
}
