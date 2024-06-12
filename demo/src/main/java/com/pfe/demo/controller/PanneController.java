package com.pfe.demo.controller;

import com.pfe.demo.entity.Accessoires;
import com.pfe.demo.entity.Panne;
import com.pfe.demo.service.AccessoiresService;
import com.pfe.demo.service.PanneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/panne")
@CrossOrigin(origins = "http://localhost:3000")
public class PanneController {
    @Autowired
    private PanneService panneService;

    @PostMapping("/addPanne")
    public ResponseEntity<Panne> createPanne(@RequestBody Panne panne) {
        Panne savedPanne = panneService.createPanne(panne);
        return new ResponseEntity<>(savedPanne, HttpStatus.CREATED);
    }

    @GetMapping("/getPanneById/{id}")
    public ResponseEntity<Panne> getPanneById(@PathVariable("id") Long panneId){
        Panne panne = panneService.getPanneById(panneId);
        return new ResponseEntity<>(panne, HttpStatus.OK);
    }


    @GetMapping("/getAllPanne")
    public ResponseEntity<List<Panne>> getAllPannes(){
        List<Panne> pannes = panneService.getAllPannes();
        return new ResponseEntity<>(pannes, HttpStatus.OK);
    }



    @DeleteMapping("/deleteAccessoires/{id}")
    public ResponseEntity<String> deletePanne(@PathVariable("id") Long panneId){
        panneService.deletePanne(panneId);
        return new ResponseEntity<>("Panne successfully deleted!", HttpStatus.OK);
    }
}
