package com.pfe.demo.service;

import com.pfe.demo.entity.Swap;
import com.pfe.demo.entity.Swap_status;
import com.pfe.demo.repository.SwapStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SwapStatusServiceImpl implements SwapStatusService {
    @Autowired
    private SwapStatusRepository swapStatusRepository;

    @Override
    public Swap_status createSwapStatus(Swap_status swapStatus) {
        return swapStatusRepository.save(swapStatus);
    }

    @Override
    public Swap_status getSwapStatusById(Integer swapStatusId) {
        Optional<Swap_status> optionalSwapStatus = swapStatusRepository.findById(swapStatusId);
        return optionalSwapStatus.get();
    }

    @Override
    public List<Swap_status> getAllSwapsStatus() {
        return swapStatusRepository.findAll();
    }

    @Override
    public Swap_status updateSwapStatus(Swap_status swapStatus) {
        Swap_status existingSwapStatus = swapStatusRepository.findById(swapStatus.getId()).get();
        existingSwapStatus.setStatus(swapStatus.getStatus());
        existingSwapStatus.setComment(swapStatus.getComment());
        existingSwapStatus.setSwap(swapStatus.getSwap());
        existingSwapStatus.setCreatedAt(swapStatus.getCreatedAt());
        existingSwapStatus.setIntervention(swapStatus.getIntervention());

        Swap_status updatedSwapStatus = swapStatusRepository.save(existingSwapStatus);
        return updatedSwapStatus;
    }

    @Override
    public void deleteSwapStatus(Integer swapStatusId) {
        swapStatusRepository.deleteById(swapStatusId);
    }
}
