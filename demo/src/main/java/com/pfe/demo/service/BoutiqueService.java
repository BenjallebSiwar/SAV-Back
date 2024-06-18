package com.pfe.demo.service;

import com.pfe.demo.entity.Boutique;
import com.pfe.demo.entity.Client;

import java.util.List;

public interface BoutiqueService {
    Boutique saveBoutique(Boutique boutique) ;
    List<Boutique> getAllBoutiques();

    Boutique getBoutiquetById(Long boutiqueId);

    Boutique updateBoutique(Boutique boutique);

    void deleteBoutique(Long boutiqueId);
}

