package com.Learning.lms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationManager;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
            .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/login", "/signup", "/css/**", "/js/**", "/images/**").permitAll()
                            .anyRequest().authenticated()
            )
            .formLogin(form -> form
                            .loginPage("/login")
                            .loginProcessingUrl("/doLogin")
                            .defaultSuccessUrl("/", true)
                            .failureUrl("/login?error=true")
                            .permitAll()
            )
            .logout(logout -> logout
                            .logoutUrl("/logout")           // URL to trigger logout
                            .logoutSuccessUrl("/login")     // Where to redirect after logout
                            .invalidateHttpSession(true)    // Invalidate session
                            .deleteCookies("JSESSIONID")    // Delete cookies
                            .clearAuthentication(true)      // Clear authentication
                            .permitAll()
            )
            .csrf(withDefaults())
            .build();
}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Use BCrypt for password encoding
    }
    @Bean
    public SecurityFilterChain filterChainWithSessionManagement(HttpSecurity http) throws Exception {
        return http
                // ... existing configuration ...
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                        .maximumSessions(1)                     // Prevent multiple sessions
                        .maxSessionsPreventsLogin(false)        // New login expires old session
                        .expiredUrl("/login?expired=true")      // Where to redirect when session expires
                )
                .build();
    }


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());  // Set the password encoder
        
        return authenticationManagerBuilder.build();
    }
}
