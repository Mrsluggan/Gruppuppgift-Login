package com.LoginGrupp3.LoginGrupp3.config;
import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    
        http
        .formLogin(withDefaults());
    
        http.authorizeHttpRequests(auth -> auth
    
        .anyRequest().permitAll()
        );
        return http.build();
    }

}
