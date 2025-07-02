package com.api.hexagonal.infraestructura.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/auth/**").permitAll() // ← AGREGAR ESTO
                        .requestMatchers(HttpMethod.POST, "/api/adjuntos/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/adjuntos/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/adjuntos/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/adjuntos/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/ongs/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/ongs/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/ongs/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/ongs/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/regiones/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/regiones/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/regiones/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/regiones/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/representantes/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/representantes/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/representantes/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/representantes/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/sectores/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/sectores/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/sectores/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/sectores/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/usuarios-admin/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/usuarios-admin/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/usuarios-admin/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/usuarios-admin/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/validaciones/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/validaciones/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/validaciones/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/validaciones/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/reniec/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/sunat/**").permitAll()
                .anyRequest().permitAll()
                );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("https://siroc.vercel.app")); // Frontend Vite
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
