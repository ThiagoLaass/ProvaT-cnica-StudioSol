package com.thiagolaass.resolvers;

import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class PontuacoesMutation implements GraphQLMutationResolver {

    public int calcularPontuacoesPossiveis(int placarA, int placarB) {
       
        return 0; 
    }
}