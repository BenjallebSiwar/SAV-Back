package com.pfe.demo.controller;

import com.pfe.demo.entity.Intervention;
import com.pfe.demo.entity.Swap;
import com.pfe.demo.service.SwapService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/swap")
public class SwapController {

    @Autowired
    private SwapService swapService;

    @PostMapping("/addSwap")
    public ResponseEntity<Swap> createSwap(@RequestBody Swap swap) {
        Swap savedSwap = swapService.createSwap(swap);
        return new ResponseEntity<>(savedSwap, HttpStatus.CREATED);
    }

    @GetMapping("/getSwapById/{id}")
    public ResponseEntity<Swap> getSwapById(@PathVariable("id") Integer SwapId){
        Swap swap = swapService.getSwapById(SwapId);
        return new ResponseEntity<>(swap, HttpStatus.OK);
    }

    @GetMapping("/getAllSwaps")
    public ResponseEntity<List<Swap>> getAllSwaps(){
        List<Swap> swaps = swapService.getAllSwaps();
        return new ResponseEntity<>(swaps, HttpStatus.OK);
    }

    @PutMapping("/updateSwapById/{id}")

    public ResponseEntity<Swap> updateSwap(@PathVariable("id") Integer SwapId,
                                                           @RequestBody Swap swap){
        swap.setId(SwapId);
        Swap updatedSwap = swapService.updateSwap(swap);
        return new ResponseEntity<>(updatedSwap, HttpStatus.OK);
    }

    @DeleteMapping("/deleteSwap/{id}")
    public ResponseEntity<String> deleteSwap(@PathVariable("id") Integer swapId){
        swapService.deleteSwap(swapId);
        return new ResponseEntity<>("Swap successfully deleted!", HttpStatus.OK);
    }

}
