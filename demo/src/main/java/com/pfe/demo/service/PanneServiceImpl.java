package com.pfe.demo.service;

import com.pfe.demo.entity.Intervention;
import com.pfe.demo.entity.Panne;
import com.pfe.demo.repository.ClientRepository;
import com.pfe.demo.repository.PanneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PanneServiceImpl implements  PanneService{

    @Autowired
    private PanneRepository panneRepository;
    @Override
    public Panne createPanne(Panne panne) {
        return panneRepository.save(panne);
    }

    @Override
    public Panne getPanneById(Long panneId) {
        Optional<Panne> optionalPanne = panneRepository.findById(panneId);
        return optionalPanne.get();
    }

    @Override
    public List<Panne> getAllPannes() {
        return panneRepository.findAll();
    }

    @Override
    public Panne updatePanne(Panne panne) {
        return null;
    }

    @Override
    public void deletePanne(Long panneId) {
        panneRepository.deleteById(panneId);
    }
}
