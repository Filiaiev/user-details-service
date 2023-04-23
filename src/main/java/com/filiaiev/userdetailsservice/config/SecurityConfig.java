package com.filiaiev.userdetailsservice.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public JWTVerifier getJwtVerifier() {
        return JWT.require(Algorithm.HMAC512(secret))
                .build();
    }

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity, JWTVerifier jwtVerifier) throws Exception {
        return httpSecurity.cors().disable()
                .authorizeHttpRequests()
//                .requestMatchers("/users/*").access(new AuthenticatedAuthorizationManager<>()).hasAuthority("CUSTOMER")
                .anyRequest().authenticated().and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtVerifier), UsernamePasswordAuthenticationFilter.class)
                .build();
        // TODO: return 401 when no token is passed, 403 when token is valid but roles are not
        // TODO: JWT FILTER SPRING
    }
}
