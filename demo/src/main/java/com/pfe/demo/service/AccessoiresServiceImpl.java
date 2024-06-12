package com.pfe.demo.service;

import com.pfe.demo.entity.Accessoires;
import com.pfe.demo.entity.Panne;
import com.pfe.demo.repository.AccessoiresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccessoiresServiceImpl implements AccessoiresService{
    @Autowired
    private AccessoiresRepository accessoiresRepository ;
    @Override
    public Accessoires createAccessoires(Accessoires accessoires) {
        return accessoiresRepository.save(accessoires);
    }

    @Override
    public Accessoires getAccessoiresById(Long accessoiresId) {
        Optional<Accessoires> optionalAccessoires = accessoiresRepository.findById(accessoiresId);
        return optionalAccessoires.get();
    }

    @Override
    public List<Accessoires> getAllAccessoires() {
        return accessoiresRepository.findAll();
    }

    @Override
    public Accessoires updateAccessoires(Accessoires accessoires) {
        return null;
    }

    @Override
    public void deleteAccessoires(Long accessoiresId) {
        accessoiresRepository.deleteById(accessoiresId);
    }
}
