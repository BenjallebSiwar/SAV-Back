package com.pfe.demo.controller;

import com.pfe.demo.entity.Accessoires;
import com.pfe.demo.entity.Client;
import com.pfe.demo.entity.Intervention;
import com.pfe.demo.service.AccessoiresService;
import com.pfe.demo.service.ClientService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/accessoires")
@CrossOrigin(origins = "http://localhost:3000")
public class AccessoiresController {
    @Autowired
    private AccessoiresService accessoiresService;

    @PostMapping("/addAccessoires")
    public ResponseEntity<Accessoires> createAccessoires(@RequestBody Accessoires accessoires) {
        Accessoires savedAccessoires = accessoiresService.createAccessoires(accessoires);
        return new ResponseEntity<>(savedAccessoires, HttpStatus.CREATED);
    }

    @GetMapping("/getAccessoiresById/{id}")
    public ResponseEntity<Accessoires> getAccessoiresById(@PathVariable("id") Long accessoiresId){
        Accessoires accessoires = accessoiresService.getAccessoiresById(accessoiresId);
        return new ResponseEntity<>(accessoires, HttpStatus.OK);
    }


    @GetMapping("/getAllAccessoires")
    public ResponseEntity<List<Accessoires>> getAllAccessoires(){
        List<Accessoires> accessoires = accessoiresService.getAllAccessoires();
        return new ResponseEntity<>(accessoires, HttpStatus.OK);
    }



    @DeleteMapping("/deleteAccessoires/{id}")
    public ResponseEntity<String> deleteAccessoires(@PathVariable("id") Long accessoiresId){
        accessoiresService.deleteAccessoires(accessoiresId);
        return new ResponseEntity<>("Accessoires successfully deleted!", HttpStatus.OK);
    }


}
