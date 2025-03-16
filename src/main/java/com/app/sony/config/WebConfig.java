/*
package com.app.sony.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply CORS to all endpoints
                .allowedOrigins("http://localhost:3000") // Allow requests from React app
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Explicitly allow OPTIONS request
                .allowedHeaders("Authorization", "Content-Type") // Allow Authorization header for Bearer token
                .allowCredentials(true); // Allow credentials if necessary
    }
}*/
