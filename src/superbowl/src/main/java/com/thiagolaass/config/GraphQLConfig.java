package com.thiagolaass.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thiagolaass.resolvers.ScoreMutationResolver;

import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;

@Configuration
public class GraphQLConfig {

    @Bean
    public GraphQLSchema graphQLSchema(ScoreMutationResolver scoreMutationResolver) {
        return SchemaParser.newParser()
                .file("classpath:schema.graphqls")
                .resolvers(scoreMutationResolver)
                .build()
                .makeExecutableSchema();
    }
}