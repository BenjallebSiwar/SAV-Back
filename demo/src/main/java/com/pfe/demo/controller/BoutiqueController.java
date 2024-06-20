package com.pfe.demo.controller;

//import com.pfe.demo.entity.Boutique;
import com.pfe.demo.entity.Client;
import com.pfe.demo.service.BoutiqueService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/boutique")
public class BoutiqueController {
    @Autowired
    BoutiqueService boutiqueService ;

//    @PostMapping("/addBoutique")
//    public ResponseEntity<?> createBoutique(@RequestBody Boutique boutique) throws IOException {
//        Boutique boutique1 = boutiqueService.saveBoutique(boutique);
//        return ResponseEntity.ok(boutique1);
//    }
//    @GetMapping("/getAllBoutiques")
//    public ResponseEntity<List<Boutique>> getAllBoutiques(){
//        List<Boutique> boutiques = boutiqueService.getAllBoutiques();
//        return new ResponseEntity<>(boutiques, HttpStatus.OK);
//    }
//    @GetMapping("/getBoutiqueById/{id}")
//    public ResponseEntity<Boutique> getBoutiqueById(@PathVariable("id") Long boutiqueId) {
//        Boutique boutique = boutiqueService.getBoutiquetById(boutiqueId);
//        return new ResponseEntity<>(boutique, HttpStatus.OK);
//    }
}
