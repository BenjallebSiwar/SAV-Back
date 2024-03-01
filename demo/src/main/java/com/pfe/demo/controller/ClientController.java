package com.pfe.demo.controller;

import com.pfe.demo.entity.Client;
import com.pfe.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/addClient")
    public ResponseEntity<?> createClient(@RequestBody Client client) throws IOException {
        Client client1 = clientService.saveClient(client);
        return ResponseEntity.ok(client1);
    }

    @GetMapping("/getAllClients")
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/getClientById/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long clientId) {
        Client client = clientService.getClientById(clientId);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PutMapping("/updateClientById/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long clientId,@RequestBody Client client){
        client.setCin(clientId);
        Client updatedClient = clientService.updateClient(client);
        return new ResponseEntity<>(updatedClient, HttpStatus.OK);
    }

    @DeleteMapping("/deleteClient/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") Long clientId){
        clientService.deleteClient(clientId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
