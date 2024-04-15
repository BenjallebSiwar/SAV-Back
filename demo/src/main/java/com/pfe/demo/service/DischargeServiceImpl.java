package com.pfe.demo.service;

import com.pfe.demo.entity.Discharge;
import com.pfe.demo.repository.DischargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DischargeServiceImpl implements DischargeService{
    @Autowired
    private DischargeRepository dischargeRepository;
    @Override
    public Discharge createDischarge(Discharge discharge) {
        return dischargeRepository.save(discharge);
    }

    @Override
    public Discharge getDischargeById(Integer dischargeId) {
        Optional<Discharge> optionalDischarge = dischargeRepository.findById(dischargeId);
        return optionalDischarge.get();
    }

    @Override
    public List<Discharge> getAllDischarges() {

        return dischargeRepository.findAll();
    }

    @Override
    public Discharge updateDischarge(Discharge discharge) {
        Discharge existingDischarge = dischargeRepository.findById(discharge.getId()).get();
        existingDischarge.setCreatedAt(discharge.getCreatedAt());
        existingDischarge.setDestination(discharge.getDestination());
        existingDischarge.setUserInfo(discharge.getUserInfo());
        existingDischarge.setInterventions(discharge.getInterventions());
        Discharge updatedDischarge = dischargeRepository.save(existingDischarge);
        return updatedDischarge;
    }

    @Override
    public void deleteDischarge(Integer dischargeId) {
        dischargeRepository.deleteById(dischargeId);
    }
}
