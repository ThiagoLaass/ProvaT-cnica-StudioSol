package com.thiagolaass.services;

import org.springframework.stereotype.Service;

import com.thiagolaass.models.Placar;

@Service
public class CombinationService {

    public int calculatePossibleCombinations(Placar placar) {
        int combinations = 0;
        int maxTouchdowns = Math.min(placar.getPontosTime1() / 6, placar.getPontosTime2() / 6);

        for (int touchdowns = maxTouchdowns; touchdowns >= 0; touchdowns--) {
            int remainingTime1Score = placar.getPontosTime1() - touchdowns * 6;
            int remainingTime2Score = placar.getPontosTime2() - touchdowns * 6;

            for (int extraPoints1 = 0; extraPoints1 <= 2; extraPoints1++) {
                for (int extraPoints2 = 0; extraPoints2 <= 2; extraPoints2++) {
                    int remainingFieldGoals1 = (remainingTime1Score - extraPoints1) / 3;
                    int remainingFieldGoals2 = (remainingTime2Score - extraPoints2) / 3;

                    if (remainingFieldGoals1 >= 0 && remainingFieldGoals2 >= 0
                            && (remainingTime1Score - extraPoints1) % 3 == 0
                            && (remainingTime2Score - extraPoints2) % 3 == 0) {
                        combinations++;
                    }
                }
            }
        }
        return combinations;
    }
}
