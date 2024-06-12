package com.pfe.demo.service;

import com.pfe.demo.entity.Accessoires;
import com.pfe.demo.entity.Swap;

import java.util.List;

public interface AccessoiresService {
    Accessoires createAccessoires(Accessoires accessoires);
    Accessoires getAccessoiresById(Long accessoiresId);

    List<Accessoires> getAllAccessoires();

    Accessoires updateAccessoires(Accessoires accessoires);

    void deleteAccessoires(Long accessoiresId);
}
