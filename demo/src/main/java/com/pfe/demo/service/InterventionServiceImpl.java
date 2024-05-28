package com.pfe.demo.service;

import com.pfe.demo.entity.Discharge;
import com.pfe.demo.entity.Intervention;
import com.pfe.demo.repository.InterventionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InterventionServiceImpl implements InterventionService{
    @Autowired
    private InterventionRepository interventionRepository;
    @Override
    public Intervention createIntervention(Intervention intervention) {
        return interventionRepository.save(intervention);
    }

    @Override
    public Intervention getInterventionById(Integer interventionId) {
        Optional<Intervention> optionalIntervention = interventionRepository.findById(interventionId);
        return optionalIntervention.get();
    }

    @Override
    public List<Intervention> getAllInterventions() {
        return interventionRepository.findAll();
    }

    @Override
    public Intervention updateIntervention(Intervention intervention) {
        Intervention existingIntervention = interventionRepository.findById(intervention.getId()).get();
        existingIntervention.setCreatedAt(intervention.getCreatedAt());
        existingIntervention.setIntervention_statuses(intervention.getIntervention_statuses());
        existingIntervention.setUserInfo(intervention.getUserInfo());
        existingIntervention.setAccessories(intervention.getAccessories());
        existingIntervention.setPanneType(intervention.getPanneType());
        existingIntervention.setDescription(intervention.getDescription());
        existingIntervention.setClient(intervention.getClient());
        existingIntervention.setDevice(intervention.getDevice());
        existingIntervention.setIntervention_statuses(intervention.getIntervention_statuses());
        existingIntervention.setClientId(intervention.getClientId());
        existingIntervention.setSwaps(intervention.getSwaps());
        existingIntervention.setSwap_statuses(intervention.getSwap_statuses());
        existingIntervention.setAvailable_clients(intervention.getAvailable_clients());
        existingIntervention.setDischarge(intervention.getDischarge());
        existingIntervention.setImei(intervention.getImei());
        existingIntervention.setStatus(intervention.getStatus());

        Intervention updatedIntervention = interventionRepository.save(existingIntervention);
        return updatedIntervention;
    }

    @Override
    public void deleteIntervention(Integer interventionId) {

        interventionRepository.deleteById(interventionId);
    }

    @Override
    public Intervention getInterventionByImei(Long imei) {
        Optional<Intervention> optionalIntervention = Optional.ofNullable(interventionRepository.findByImei(imei));
        return optionalIntervention.get();
    }

}
