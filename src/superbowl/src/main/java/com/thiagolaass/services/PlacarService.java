package com.thiagolaass.services;

import org.springframework.stereotype.Service;

@Service
public class PlacarService {

    public int calculatePossibleCombinations(int pontosTime1, int pontosTime2) {
        int combinations = 0;
        for (int touchdowns = 0; touchdowns <= Math.min(pontosTime1 / 6, pontosTime2 / 6); touchdowns++) {
            int remainingTime1Score = pontosTime1 - touchdowns * 6;
            int remainingTime2Score = pontosTime2 - touchdowns * 6;
            if (remainingTime1Score % 3 == 0 && remainingTime2Score % 3 == 0) {
                combinations++;
            }
        }

        return combinations;
    }
}

