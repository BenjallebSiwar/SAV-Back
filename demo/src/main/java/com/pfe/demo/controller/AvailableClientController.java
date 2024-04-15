package com.pfe.demo.controller;

import com.pfe.demo.entity.Available_client;
import com.pfe.demo.service.AvailableClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/availableClient")
public class AvailableClientController {
    @Autowired
    private AvailableClientService availableClientService;

    @PostMapping("/addAvailableClient")
    public ResponseEntity<?> createAvailableClient(@RequestBody Available_client client) throws IOException {
        Available_client availableClient = availableClientService.saveAvailableClient(client);
        return ResponseEntity.ok(availableClient );
    }

    @GetMapping("/getAllAvailableClients")
    public ResponseEntity<List<Available_client>> getAllAvailableClients(){
        List<Available_client> clients = availableClientService.getAllAvailableClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/getAvailableClientById/{id}")
    public ResponseEntity<Available_client> getAvailableClientById(@PathVariable("id") Integer availableClientId) {
        Available_client availableClient = availableClientService.getAvailableClientById(availableClientId);
        return new ResponseEntity<>(availableClient, HttpStatus.OK);
    }

    @PutMapping("/updateAvailableClientById/{id}")
    public ResponseEntity<Available_client> updateAvailableClient(@PathVariable("id") Integer availableClientId,@RequestBody Available_client availableClient){
        availableClient.setId(availableClientId);
        Available_client updatedAvailableClient = availableClientService.updateAvailableClient(availableClient);
        return new ResponseEntity<>(updatedAvailableClient, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAvailableClient/{id}")
    public ResponseEntity<String> deleteAvailableClient(@PathVariable("id") Integer availableClientId){
        availableClientService.deleteAvailableClient(availableClientId);
        return new ResponseEntity<>("Available Client successfully deleted!", HttpStatus.OK);
    }
}
