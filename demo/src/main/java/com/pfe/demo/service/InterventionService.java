package com.pfe.demo.service;


import com.pfe.demo.entity.Intervention;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InterventionService {

    Intervention createIntervention(Intervention intervention);
    Intervention getInterventionById(Integer interventionId);

    List<Intervention> getAllInterventions();

    Intervention updateIntervention(Intervention intervention);

    void deleteIntervention(Integer interventionId);
}
