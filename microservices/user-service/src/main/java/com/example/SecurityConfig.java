package com.example;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public UserDetailsManager userDetailsManager(DataSource datasource) {
    return new JdbcUserDetailsManager(datasource);
  }
  
  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(configurer -> {
      configurer.antMatchers("/actuator/**").permitAll();
      configurer.anyRequest().authenticated();
    });
    http.httpBasic();
    http.cors().disable();
    http.csrf().disable();
    return http.build();
  }

}