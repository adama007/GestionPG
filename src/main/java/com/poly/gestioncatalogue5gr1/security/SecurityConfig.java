package com.poly.gestioncatalogue5gr1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        User.withUsername("user").password(passwordEncoder().encode("1234")).roles("USER").build();
        User.withUsername("admin").password(passwordEncoder().encode("1234")).roles("ADMIN","USER").build();

        return new InMemoryUserDetailsManager(user);
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{


        httpSecurity.formLogin(form->form.permitAll());
        Security.authorizeHttpRequests(authorize->authorize.requestMatchers("/user/**").hasRole("USER"));
        Security.authorizeHttpRequests(authorize->authorize.requestMatchers("/admin/**").hasRole("admin"));
        httpSecurity.authorizeHttpRequests(authorize->authorize.anyRequest().authentificated());
        return httpSecurity.build();
    }
     
}
