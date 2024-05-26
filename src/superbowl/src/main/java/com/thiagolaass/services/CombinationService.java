package com.thiagolaass.services;

import org.springframework.stereotype.Service;

import com.thiagolaass.models.Placar;

@Service
public class CombinationService {

    public int calculatePossibleCombinations(Placar placar) {
        int combinations = 0;
        for (int touchdowns = 0; touchdowns <= Math.min(placar.getPontosTime1() / 6, placar.getPontosTime2() / 6); touchdowns++) {
            int remainingTime1Score = placar.getPontosTime1() - touchdowns * 6;
            int remainingTime2Score = placar.getPontosTime2() - touchdowns * 6;
            if (remainingTime1Score % 3 == 0 && remainingTime2Score % 3 == 0) {
                combinations++;
            }
        }
        return combinations;
    }
}

