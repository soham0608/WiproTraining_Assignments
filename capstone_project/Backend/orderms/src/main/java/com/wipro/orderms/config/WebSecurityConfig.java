package com.wipro.orderms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
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
 	       .requestMatchers("/cart/**").permitAll()
           .requestMatchers("/order/**").authenticated()
           .requestMatchers(
                   "/swagger-ui/**",
                   "/swagger-ui.html",
                   "/v3/api-docs/**"
               ).permitAll()
            .anyRequest().authenticated()
 ) 
           
            .build();
    }
}