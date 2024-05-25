package com.thiagolaass.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.Servlet;

@Configuration
public class GraphQLServletConfig {

    @Bean
    public ServletRegistrationBean<Servlet> graphQLServletRegistrationBean(Servlet graphQLHttpServlet) {
        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>(graphQLHttpServlet, "/graphql");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }
}
