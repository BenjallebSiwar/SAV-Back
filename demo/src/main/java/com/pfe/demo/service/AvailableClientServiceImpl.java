package com.pfe.demo.service;

import com.pfe.demo.entity.Available_client;

import com.pfe.demo.repository.AvailableClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvailableClientServiceImpl implements AvailableClientService {
    @Autowired
    private AvailableClientRepository availableClientRepository;
    @Override
    public Available_client saveAvailableClient(Available_client availableClient) {
        return availableClientRepository.save(availableClient);
    }

    @Override
    public List<Available_client> getAllAvailableClients() {
        return availableClientRepository.findAll();
    }

    @Override
    public Available_client getAvailableClientById(Integer availableClientId) {
        Optional<Available_client> availableClient = availableClientRepository.findById(availableClientId);
        return availableClient.get();
    }

    @Override
    public Available_client updateAvailableClient(Available_client AvailableClient) {
        Available_client existingAvailableClient = availableClientRepository.findById(AvailableClient.getId()).get();
        existingAvailableClient.setComment(AvailableClient.getComment());
        existingAvailableClient.setShop(AvailableClient.getShop());
        existingAvailableClient.setIntervention(AvailableClient.getIntervention());


        Available_client updatedAvailableClient = availableClientRepository.save(existingAvailableClient);
        return updatedAvailableClient;
    }

    @Override
    public void deleteAvailableClient(Integer AvailableClientId) {
        availableClientRepository.deleteById(AvailableClientId);
    }
}
