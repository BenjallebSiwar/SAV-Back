package com.pfe.demo.service;


import com.pfe.demo.entity.Discharge;
import com.pfe.demo.entity.Intervention;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface InterventionService {

    Intervention createIntervention(Intervention intervention);
    Intervention getInterventionById(Integer interventionId);
    Intervention getInterventionByImei(Long imei);
    Intervention getInterventionByCin(Integer cin);
    List<Intervention> getAllInterventions();

    Intervention updateIntervention(Intervention intervention);
    List<Intervention> getInterventionsByClientCin(Long cin);
    List<Intervention> getInterventionsWithInterneWorkflow();
    List<Intervention> getInterventionsWithExterneWorkflow();
    String getRepairType(Intervention intervention);

    void deleteIntervention(Integer interventionId);

    List<Intervention> findByDischargeIsNotNull();
    Optional<Intervention> getInterventionByDischargeId(Integer dischargeId);
    boolean hasDischarge(Integer interventionId);


}
