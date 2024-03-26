package com.example.softwareecommers.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer.requestMatchers(HttpMethod.GET, "/cart").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/cart").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/payment").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/payment").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/logout").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/logout").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/market").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/market/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/market/**").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/market/approve").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/market/approve").hasRole("ADMIN"));
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }


}
