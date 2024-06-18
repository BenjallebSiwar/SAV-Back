package com.pfe.demo.service;

import com.pfe.demo.entity.Boutique;
import com.pfe.demo.entity.Client;
import com.pfe.demo.repository.BoutiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoutiqueServiceImpl implements BoutiqueService{
    @Autowired
    BoutiqueRepository boutiqueRepository;
    @Override
    public Boutique saveBoutique(Boutique boutique) {
        return boutiqueRepository.save(boutique);
    }

    @Override
    public List<Boutique> getAllBoutiques() {
        return boutiqueRepository.findAll();
    }

    @Override
    public Boutique getBoutiquetById(Long boutiqueId) {
        Optional<Boutique> boutique = boutiqueRepository.findById(boutiqueId);
        return boutique.get();
    }

    @Override
    public Boutique updateBoutique(Boutique boutique) {
        return null;
    }

    @Override
    public void deleteBoutique(Long boutiqueId) {
        boutiqueRepository.deleteById(boutiqueId);
    }
}
