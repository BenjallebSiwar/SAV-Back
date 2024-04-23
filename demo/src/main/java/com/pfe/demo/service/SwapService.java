package com.pfe.demo.service;

import com.pfe.demo.entity.Discharge;
import com.pfe.demo.entity.Swap;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SwapService {
    Swap createSwap(Swap swap);
    Swap getSwapById(Integer swapId);

    List<Swap> getAllSwaps();

    Swap updateSwap(Swap swap);

    void deleteSwap(Integer swapId);
}
