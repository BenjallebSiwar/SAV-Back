package com.pfe.demo.service;

import com.pfe.demo.entity.Client;
import com.pfe.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client saveClient(Client client) {

        return clientRepository.save(client);

    }

    @Override
    public List<Client> getAllClients() {

        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);
        return client.get();
    }

    @Override
    public Client updateClient(Client client) {
        Client existingClient = clientRepository.findById(client.getCin()).get();
        existingClient.setFirstName(client.getFirstName());
        existingClient.setLastName(client.getLastName());
        existingClient.setEmail(client.getEmail());
        existingClient.setPhoneNumber1(client.getPhoneNumber1());
        existingClient.setPhoneNumber2(client.getPhoneNumber2());
        existingClient.setInterventions(client.getInterventions());

        Client updatedClient = clientRepository.save(existingClient);
        return updatedClient;
    }

    @Override
    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }
}
