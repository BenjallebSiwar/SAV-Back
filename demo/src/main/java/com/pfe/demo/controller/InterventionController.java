package com.pfe.demo.controller;



import com.pfe.demo.entity.Intervention;
import com.pfe.demo.service.InterventionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/intervention")
public class InterventionController {
    @Autowired
    private InterventionService interventionService;


    @PostMapping("/addIntervention")
    public ResponseEntity<Intervention> createIntervention(@RequestBody Intervention intervention) {
        Intervention savedIntervention = interventionService.createIntervention(intervention);
        return new ResponseEntity<>(savedIntervention, HttpStatus.CREATED);
    }

    @GetMapping("/getInterventionById/{id}")
    public ResponseEntity<Intervention> getInterventionById(@PathVariable("id") Integer interventionId){
        Intervention intervention = interventionService.getInterventionById(interventionId);
        return new ResponseEntity<>(intervention, HttpStatus.OK);
    }
    @GetMapping("/getInterventionByCin/{cin}")
    public ResponseEntity<Intervention> getInterventionByCin(@PathVariable("cin") Integer clientCin){
        Intervention intervention = interventionService.getInterventionByCin(clientCin);
        return new ResponseEntity<>(intervention, HttpStatus.OK);
    }
    @GetMapping("/getInterventionByImei/{imei}")
    public ResponseEntity<Intervention> getInterventionByImei(@PathVariable("imei") Long imei) {
        Intervention intervention = interventionService.getInterventionByImei(imei);
        return new ResponseEntity<>(intervention, HttpStatus.OK);
    }

    @GetMapping("/getAllInterventions")
    public ResponseEntity<List<Intervention>> getAllInterventions(){
        List<Intervention> interventions = interventionService.getAllInterventions();
        return new ResponseEntity<>(interventions, HttpStatus.OK);
    }

    @PutMapping("/updateInterventionById/{id}")
    public ResponseEntity<Intervention> updateIntervention(@PathVariable("id") Integer InterventionId,
                                                     @RequestBody Intervention intervention){
        intervention.setId(InterventionId);
        Intervention updatedIntervention = interventionService.updateIntervention(intervention);
        return new ResponseEntity<>(updatedIntervention, HttpStatus.OK);
    }

    @DeleteMapping("/deleteIntervention/{id}")
    public ResponseEntity<String> deleteIntervention(@PathVariable("id") Integer interventionId){
        interventionService.deleteIntervention(interventionId);
        return new ResponseEntity<>("Intervention successfully deleted!", HttpStatus.OK);
    }
}
