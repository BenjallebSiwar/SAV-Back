package com.pfe.demo.service;

import com.pfe.demo.entity.Available_client;
import com.pfe.demo.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AvailableClientService {

    Available_client saveAvailableClient(Available_client availableClient) ;
    List<Available_client> getAllAvailableClients();

    Available_client getAvailableClientById(Integer availableClientId);

    Available_client updateAvailableClient(Available_client AvailableClient);

    void deleteAvailableClient(Integer AvailableClientId);
}
