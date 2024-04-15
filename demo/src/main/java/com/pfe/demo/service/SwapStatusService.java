package com.pfe.demo.service;

import com.pfe.demo.entity.Swap;
import com.pfe.demo.entity.Swap_status;

import java.util.List;

public interface SwapStatusService {
    Swap_status createSwapStatus(Swap_status swapStatus);
    Swap_status getSwapStatusById(Integer swapStatusId);

    List<Swap_status> getAllSwapsStatus();

    Swap_status updateSwapStatus(Swap_status swapStatus);

    void deleteSwapStatus(Integer swapStatusId);
}
