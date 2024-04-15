package com.pfe.demo.service;

import com.pfe.demo.entity.Device;
import com.pfe.demo.entity.Discharge;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DischargeService {

    Discharge createDischarge(Discharge discharge);
    Discharge getDischargeById(Integer dischargeId);

    List<Discharge> getAllDischarges();

    Discharge updateDischarge(Discharge discharge);

    void deleteDischarge(Integer dischargeId);
}
