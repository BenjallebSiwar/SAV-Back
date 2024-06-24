package com.pfe.demo.controller;

import com.pfe.demo.entity.Intervention;
import com.pfe.demo.entity.Intervention_status;
import com.pfe.demo.service.InterventionStatusService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/interventionStatus")
public class InterventionStatusController {
    @Autowired
    private InterventionStatusService interventionStatusService;

    @PostMapping("/addInterventionStatus")
    public ResponseEntity<Intervention_status> createInterventionStatus(@RequestBody Intervention_status interventionStatus) {
        Intervention_status savedInterventionStatus = interventionStatusService.createInterventionStatus(interventionStatus);
       // CHANGE DEVICE STATUS
        return new ResponseEntity<>(savedInterventionStatus, HttpStatus.CREATED);
    }

    @GetMapping("/getInterventionStatusById/{id}")
    public ResponseEntity<Intervention_status> getInterventionStatusById(@PathVariable("id") Integer interventionStatusId){
        Intervention_status interventionStatus = interventionStatusService.getInterventionStatusById(interventionStatusId);
        return new ResponseEntity<>(interventionStatus, HttpStatus.OK);
    }

    @GetMapping("/getAllInterventionsStatus")
    public ResponseEntity<List<Intervention_status>> getAllInterventionsStatus(){
        List<Intervention_status> interventionsStatus = interventionStatusService.getAllInterventionsStatus();
        return new ResponseEntity<>(interventionsStatus, HttpStatus.OK);
    }

    @PutMapping("/updateInterventionStatusById/{id}")

    public ResponseEntity<Intervention_status> updateInterventionStatus(@PathVariable("id") Integer InterventionStatusId,
                                                           @RequestBody Intervention_status interventionStatus){
        interventionStatus.setId(InterventionStatusId);
        Intervention_status updatedInterventionStatus = interventionStatusService.updateInterventionStatus(interventionStatus);
        return new ResponseEntity<>(updatedInterventionStatus, HttpStatus.OK);
    }

    @DeleteMapping("/deleteInterventionStatus/{id}")
    public ResponseEntity<String> deleteInterventionStatus(@PathVariable("id") Integer interventionStatusId){
        interventionStatusService.deleteInterventionStatus(interventionStatusId);
        return new ResponseEntity<>("InterventionStatus successfully deleted!", HttpStatus.OK);
    }
}
