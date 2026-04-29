package com.challenge.api.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    private final ApiKeyValidator apiKeyValidator;

    public SecurityConfig(ApiKeyValidator apiKeyValidator) {
        this.apiKeyValidator = apiKeyValidator;
    }

    @Bean
    public FilterRegistrationBean<ApiKeyValidator> apiKeyFilterRegistration() {
        FilterRegistrationBean<ApiKeyValidator> registration = new FilterRegistrationBean<>();
        registration.setFilter(apiKeyValidator);
        registration.addUrlPatterns("/api/*");
        return registration;
    }
}
