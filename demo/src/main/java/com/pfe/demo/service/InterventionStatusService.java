package com.pfe.demo.service;

import com.pfe.demo.entity.Intervention;
import com.pfe.demo.entity.Intervention_status;
import org.springframework.stereotype.Service;

import java.util.List;


public interface InterventionStatusService {

    Intervention_status createInterventionStatus(Intervention_status interventionStatus);
    Intervention_status getInterventionStatusById(Integer interventionStatusId);

    List<Intervention_status> getAllInterventionsStatus();

    Intervention_status updateInterventionStatus(Intervention_status interventionStatus);

    void deleteInterventionStatus(Integer interventionStatusId);
}
