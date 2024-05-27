package com.thiagolaass.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.thiagolaass.models.Placar;

@Service
public class CombinationService {

    public int calculatePossibleCombinations(Placar placar) {
        int combinations1 = calculateCombinations(placar.getPontosTime1());
        int combinations2 = calculateCombinations(placar.getPontosTime2());

        return combinations1 * combinations2;
    }
        private static int calculateCombinations(int score) {
        int[] scores = {3, 6, 7, 8};
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int i = 1; i <= score; i++) {
            dp.put(i, 0);
            for (int s : scores) {
                if (i >= s) {
                    dp.put(i, dp.get(i) + dp.getOrDefault(i - s, 0));
                }
            }
        }
        return dp.get(score);
    }

}
