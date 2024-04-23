package com.pfe.demo.service;

import com.pfe.demo.entity.Intervention;
import com.pfe.demo.entity.Intervention_status;
import com.pfe.demo.repository.InterventionStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InterventionStatusServiceImpl implements InterventionStatusService {
    @Autowired
    private InterventionStatusRepository interventionStatusRepository;
    @Override
    public Intervention_status createInterventionStatus(Intervention_status interventionStatus) {
        return interventionStatusRepository.save(interventionStatus);
    }

    @Override
    public Intervention_status getInterventionStatusById(Integer interventionStatusId) {
        Optional<Intervention_status> optionalInterventionStatus = interventionStatusRepository.findById(interventionStatusId);
        return optionalInterventionStatus.get();
    }

    @Override
    public List<Intervention_status> getAllInterventionsStatus() {
        return interventionStatusRepository.findAll();
    }

    @Override
    public Intervention_status updateInterventionStatus(Intervention_status interventionStatus) {
        Intervention_status existingInterventionStatus = interventionStatusRepository.findById(interventionStatus.getId()).get();
        existingInterventionStatus.setCreatedAt(interventionStatus.getCreatedAt());
        existingInterventionStatus.setIntervention(interventionStatus.getIntervention());
        existingInterventionStatus.setStatus(interventionStatus.getStatus());
        existingInterventionStatus.setAmount(interventionStatus.getAmount());
        existingInterventionStatus.setLocal(interventionStatus.getLocal());
        existingInterventionStatus.setMarque(interventionStatus.getMarque());
        existingInterventionStatus.setPdfLink(interventionStatus.getPdfLink());
        existingInterventionStatus.setModele(interventionStatus.getModele());
        existingInterventionStatus.setNewIMEI(interventionStatus.getNewIMEI());
        Intervention_status updatedInterventionStatus = interventionStatusRepository.save(existingInterventionStatus);
        return updatedInterventionStatus;
    }

    @Override
    public void deleteInterventionStatus(Integer interventionStatusId) {
        interventionStatusRepository.deleteById(interventionStatusId);
    }
}
