package com.wipro.userms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
        	.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)

            .csrf(csrf -> csrf.disable())
                       .authorizeHttpRequests(
            	        auth -> auth.requestMatchers("/user/login/**").permitAll()
            	        .requestMatchers(HttpMethod.POST, "/user").permitAll()
                       .anyRequest().authenticated()
            ) 
           
            .build();
    }
}