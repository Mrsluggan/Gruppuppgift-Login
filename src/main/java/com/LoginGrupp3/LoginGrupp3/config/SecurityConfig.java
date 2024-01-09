package com.LoginGrupp3.LoginGrupp3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request) -> request
        .requestMatchers("/").permitAll()
        .requestMatchers("/login").permitAll()
        .requestMatchers("/details").authenticated()
        .requestMatchers("/createNewAccount").permitAll()
        .requestMatchers("/image.png").permitAll()
        .requestMatchers("/newUser").permitAll()
        
         
        )
        .formLogin(Customizer.withDefaults())
        .httpBasic(Customizer.withDefaults());
        
        
        return http.build();
    }

}
