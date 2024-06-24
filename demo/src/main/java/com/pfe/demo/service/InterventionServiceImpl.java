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
        if (intervention.getStatus() == null) {
            intervention.setStatus("ouverte");
        }
        if (intervention.getEtat() == null) {
            intervention.setEtat("en cours de diagnostic");
        }
        return interventionRepository.save(intervention);
    }

    @Override
    public Intervention getInterventionById(Integer interventionId) {
        Optional<Intervention> optionalIntervention = interventionRepository.findById(interventionId);
        return optionalIntervention.get();
    }
    @Override
    public Intervention getInterventionByImei(Long imei) {
        Optional<Intervention> optionalIntervention = Optional.ofNullable(interventionRepository.findByImei(imei));
        return optionalIntervention.get();
    }
    @Override
    public Intervention getInterventionByCin(Integer cin) {
        Optional<Intervention> optionalIntervention = (interventionRepository.findById(cin));
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

        existingIntervention.setDescription(intervention.getDescription());
        existingIntervention.setClient(intervention.getClient());
        existingIntervention.setDevice(intervention.getDevice());
        existingIntervention.setIntervention_statuses(intervention.getIntervention_statuses());
//        existingIntervention.setClientId(intervention.getClientId());
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
    public List<Intervention> getInterventionsByClientCin(Long cin) {
        return interventionRepository.findByClientCin(cin);
    }

    @Override
    public List<Intervention> getInterventionsWithInterneWorkflow() {
        return interventionRepository.findByWorkflow("interne");
    }

    @Override
    public List<Intervention> getInterventionsWithExterneWorkflow() {
        return interventionRepository.findByWorkflow("externe");
    }

    @Override
    public void deleteIntervention(Integer interventionId) {

        interventionRepository.deleteById(interventionId);
    }

    @Override
    public List<Intervention> findByDischargeIsNotNull() {
        return interventionRepository.findByDischargeIsNotNull();
    }


    @Override
    public String getRepairType(Intervention intervention) {
        String workflow = intervention.getWorkflow();
        if ("externe".equalsIgnoreCase(workflow)) {
            return "En attente Envoi Réparateur externe";
        } else if ("interne".equalsIgnoreCase(workflow)) {
            return "En attente Envoi Réparateur interne";
        } else {
            return "En attente Envoi Workflow normal"; // Assuming "normal" or other cases should return a default value
        }
    }
    @Override
    public Optional<Intervention> getInterventionByDischargeId(Integer dischargeId) {
        return interventionRepository.findByDischargeId(dischargeId);
    }

    @Override
    public boolean hasDischarge(Integer interventionId) {
        Optional<Intervention> intervention = interventionRepository.findById(interventionId);
        return intervention.map(value -> value.getDischarge() != null).orElse(false);
    }

}
