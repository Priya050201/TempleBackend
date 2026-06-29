package com.example.Karaikadeeshwarar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/auth/**").permitAll()
            .requestMatchers("/api/**").permitAll()
            .requestMatchers("/festival/**").permitAll()
            .requestMatchers("/renovation/**").permitAll()
            .requestMatchers("/donation/**").permitAll()
            .anyRequest().permitAll()   // IMPORTANT for now
        )
        .formLogin(form -> form.disable())
        .httpBasic(basic -> basic.disable());

    return http.build();
}

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOriginPatterns(List.of(
    "https://temple-frontend-git-main-priya050201s-projects.vercel.app",
    "http://localhost:5173",
    "https://temple-frontend-2o6zbxayq-priya050201s-projects.vercel.app"
));

        config.setAllowedMethods(
                List.of("GET","POST","PUT","DELETE","OPTIONS")
        );

        config.setAllowedHeaders(
                List.of("*")
        );

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", config);

        return source;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
