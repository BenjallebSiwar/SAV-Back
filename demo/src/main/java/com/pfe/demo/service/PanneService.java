package com.pfe.demo.service;

import com.pfe.demo.entity.Panne;
import com.pfe.demo.entity.Swap;

import java.util.List;

public interface PanneService {
    Panne createPanne(Panne panne);
    Panne getPanneById(Long panneId);

    List<Panne> getAllPannes();

    Panne updatePanne(Panne panne);

    void deletePanne(Long panneId);
}
