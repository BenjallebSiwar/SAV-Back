package com.pfe.demo.service;


import com.pfe.demo.entity.Discharge;
import com.pfe.demo.entity.Intervention;
import com.pfe.demo.entity.Swap;
import com.pfe.demo.repository.DischargeRepository;
import com.pfe.demo.repository.SwapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SwapServiceImpl implements SwapService{

    @Autowired
    private SwapRepository swapRepository;
    @Override
    public Swap createSwap(Swap swap) {
        return swapRepository.save(swap);
    }

    @Override
    public Swap getSwapById(Integer swapId) {
        Optional<Swap> optionalSwap = swapRepository.findById(swapId);
        return optionalSwap.get();
    }

    @Override
    public List<Swap> getAllSwaps() {
        return swapRepository.findAll();
    }

    @Override
    public Swap updateSwap(Swap swap) {
        Swap existingSwap = swapRepository.findById(swap.getId()).get();
        existingSwap.setBrand(swap.getBrand());
        existingSwap.setImei(swap.getImei());
        existingSwap.setPrice(swap.getPrice());
        existingSwap.setModel(swap.getModel());
        existingSwap.setStatus(swap.getStatus());
//        existingSwap.setSwap_statuses(swap.getSwap_statuses());
        existingSwap.setIntervention(swap.getIntervention());

        Swap updatedSwap = swapRepository.save(existingSwap);
        return updatedSwap;
    }

    @Override
    public void deleteSwap(Integer swapId) {
        swapRepository.deleteById(swapId);
    }

}
