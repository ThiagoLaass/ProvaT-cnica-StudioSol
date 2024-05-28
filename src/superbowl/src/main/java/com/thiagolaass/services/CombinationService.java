package com.thiagolaass.services;

import org.springframework.stereotype.Service;

import com.thiagolaass.models.Placar;

@Service
public class CombinationService {

    public int calculatePossibleCombinations(Placar placar) {
        return calculateCombinations(placar.getPontosTime1()) * calculateCombinations(placar.getPontosTime2());
    }
    
    // Método para calcular o número de combinações para um placar específico
    public static int calculateCombinations(int score) {
        int combinations = 0;

        // Calcula o número de touchdowns possíveis
        for (int touchdowns = 0; touchdowns <= score / 6; touchdowns++) {
            // Calcula o placar restante após marcar touchdowns
            int remainingScore = score - touchdowns * 6;
    
            // Calcula o número de field goals possíveis para o placar restante
            for (int fieldGoals = 0; fieldGoals <= remainingScore / 3; fieldGoals++) {
                // Calcula o placar restante após marcar field goals
                int remainingScoreAfterFieldGoals = remainingScore - fieldGoals * 3;
    
                // Se o placar restante for zero, encontramos uma combinação válida
                if (remainingScoreAfterFieldGoals == 0) {
                    combinations++;
                }
            }
        }
        return combinations;
    }
}