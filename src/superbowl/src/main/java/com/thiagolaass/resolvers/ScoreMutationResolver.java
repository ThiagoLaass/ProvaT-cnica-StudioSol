package com.thiagolaass.resolvers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thiagolaass.services.PlacarService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class ScoreMutationResolver implements GraphQLMutationResolver {

    private final PlacarService placarService;

    @Autowired
    public ScoreMutationResolver(PlacarService placarService) {
        this.placarService = placarService;
    }

    public int calculatePossibleCombinations(int homeScore, int awayScore) {
        return placarService.calculatePossibleCombinations(homeScore, awayScore);
    }
}