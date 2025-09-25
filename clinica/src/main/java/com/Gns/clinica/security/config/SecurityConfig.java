package com.Gns.clinica.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    private final JwtFilter jwtFilter;

    @Autowired
    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize

                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/users").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/users/dni/*").hasAnyRole("DOCTOR", "PATIENT", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/users/*").hasAnyRole("DOCTOR", "PATIENT", "ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/specialties/name/*",
                                "/api/specialties/public").permitAll()

                        .requestMatchers(HttpMethod.GET, "/api/availability/date/*",
                                "/api/availability/dates/**").permitAll()
                        .requestMatchers(HttpMethod.PATCH,"/api/availability/*").hasAnyRole("DOCTOR", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/availability/*").hasAnyRole("DOCTOR", "ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/branch/name/**").permitAll()

                        .requestMatchers(HttpMethod.GET, "/api/reservation/doctor/*").hasAnyRole("DOCTOR", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/reservation/patient/*").hasAnyRole("PATIENT", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/reservation").hasAnyRole("PATIENT", "ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/consultation/patient/*").hasAnyRole("PATIENT", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/consultation/doctor/*").hasAnyRole("DOCTOR", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/consultation/**").hasAnyRole("DOCTOR", "ADMIN")
                        .requestMatchers("/api/**").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
