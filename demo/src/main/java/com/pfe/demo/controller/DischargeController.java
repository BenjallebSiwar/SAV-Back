package com.pfe.demo.controller;

import com.pfe.demo.entity.Discharge;
import com.pfe.demo.service.DischargeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/discharge")
public class DischargeController {
    @Autowired
    private DischargeService dischargeService;
    @PostMapping("/addDischarge")
    public ResponseEntity<Discharge> createDischarge(@RequestBody Discharge discharge) {
        Discharge savedDischarge = dischargeService.createDischarge(discharge);
        return new ResponseEntity<>(savedDischarge, HttpStatus.CREATED);
    }

    @GetMapping("/getDischargeById/{id}")
    public ResponseEntity<Discharge> getDischargeById(@PathVariable("id") Integer dischargeId){
        Discharge discharge = dischargeService.getDischargeById(dischargeId);
        return new ResponseEntity<>(discharge, HttpStatus.OK);
    }

    @GetMapping("/getAllDischarges")
    public ResponseEntity<List<Discharge>> getAllDischarges(){
        List<Discharge> discharges = dischargeService.getAllDischarges();
        return new ResponseEntity<>(discharges, HttpStatus.OK);
    }

    @PutMapping("/updateDischargeById/{id}")

    public ResponseEntity<Discharge> updateDischarge(@PathVariable("id") Integer dischargeId,
                                           @RequestBody Discharge discharge){
        discharge.setId(dischargeId);
        Discharge updatedDischarge = dischargeService.updateDischarge(discharge);
        return new ResponseEntity<>(updatedDischarge, HttpStatus.OK);
    }

    @DeleteMapping("/deleteDischarge/{id}")
    public ResponseEntity<String> deleteDischarge(@PathVariable("id") Integer dischargeId){
        dischargeService.deleteDischarge(dischargeId);
        return new ResponseEntity<>("Discharge successfully deleted!", HttpStatus.OK);
    }






}
