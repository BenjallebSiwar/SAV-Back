package com.pfe.demo.controller;

import com.pfe.demo.entity.Swap;
import com.pfe.demo.entity.Swap_status;
import com.pfe.demo.service.SwapStatusService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/swapStatus")
public class SwapStatusController {
    @Autowired
    private SwapStatusService swapStatusService;

    @PostMapping("/addSwapStatus")
    public ResponseEntity<Swap_status> createSwapStatus(@RequestBody Swap_status swapStatus) {
        Swap_status savedSwapStatus = swapStatusService.createSwapStatus(swapStatus);
        return new ResponseEntity<>(savedSwapStatus, HttpStatus.CREATED);
    }

    @GetMapping("/getSwapStatusById/{id}")
    public ResponseEntity<Swap_status> getSwapStatusById(@PathVariable("id") Integer SwapStatusId){
        Swap_status swapStatus = swapStatusService.getSwapStatusById(SwapStatusId);
        return new ResponseEntity<>(swapStatus, HttpStatus.OK);
    }

    @GetMapping("/getAllSwapsStatus")
    public ResponseEntity<List<Swap_status>> getAllSwapsStatus(){
        List<Swap_status> swapsStatus = swapStatusService.getAllSwapsStatus();
        return new ResponseEntity<>(swapsStatus, HttpStatus.OK);
    }

    @PutMapping("/updateSwapStatusById/{id}")

    public ResponseEntity<Swap_status> updateSwapStatus(@PathVariable("id") Integer swapStatusId,
                                           @RequestBody Swap_status swapStatus){
        swapStatus.setId(swapStatusId);
        Swap_status updatedSwapStatus = swapStatusService.updateSwapStatus(swapStatus);
        return new ResponseEntity<>(updatedSwapStatus, HttpStatus.OK);
    }

    @DeleteMapping("/deleteSwapStatus/{id}")
    public ResponseEntity<String> deleteSwapStatus(@PathVariable("id") Integer swapStatusId){
        swapStatusService.deleteSwapStatus(swapStatusId);
        return new ResponseEntity<>("Swap successfully deleted!", HttpStatus.OK);
    }






}
