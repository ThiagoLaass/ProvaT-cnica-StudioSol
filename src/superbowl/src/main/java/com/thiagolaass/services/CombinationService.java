package com.thiagolaass.services;

import org.springframework.stereotype.Service;

import com.thiagolaass.models.Placar;

@Service
public class CombinationService {

    public int calculatePossibleCombinations(Placar placar) {
        return calcularCombinacoes(placar.getPontosTime1(), placar.getPontosTime2());
    }
    
    // Método para calcular o número de combinações para um placar específico
    public  int calcularCombinacoes(int placarA, int placarB) {
        int[] pontos = {6, 3}; // Touchdown e Field Goal
        int maxPlacar = Math.max(placarA, placarB);
        int[] dp = new int[maxPlacar + 1];
        dp[0] = 1; // A única maneira de fazer 0 pontos é não fazer nada

        // Para cada tipo de ponto
        for (int ponto : pontos) {
            // Para cada possível pontuação até o placar máximo
            for (int i = ponto; i <= maxPlacar; i++) {
                // O número de combinações possíveis até agora é a soma do número de combinações
                // até i menos o ponto atual e o número de combinações para i com o ponto atual
                dp[i] += dp[i - ponto];
            }
        }

        return dp[placarA] + dp[placarB];
    }
}