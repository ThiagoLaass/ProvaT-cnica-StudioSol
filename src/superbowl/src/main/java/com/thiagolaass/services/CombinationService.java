package com.thiagolaass.services;

import org.springframework.stereotype.Service;

import com.thiagolaass.models.Placar;

@Service
public class CombinationService {

    public int calculatePossibleCombinations(Placar placar) {
        return calcularCombinacoes(placar.getPontosTime1(), placar.getPontosTime2());
    }

    public int calcularCombinacoes(int placarA, int placarB) {
        int[] pontos = {6, 3};
        int maxPlacar = Math.max(placarA, placarB);
        int[] dp = new int[maxPlacar + 1];
        dp[0] = 1;
        for (int ponto : pontos) {
            for (int i = ponto; i <= maxPlacar; i++) {
                dp[i] += dp[i - ponto];
            }
        }
        return dp[placarA] + dp[placarB];
    }
}