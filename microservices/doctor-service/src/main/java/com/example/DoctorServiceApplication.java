package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.UserDetailsManager;

@SpringBootApplication
@EnableDiscoveryClient
@SuppressWarnings("PMD.UseUtilityClass")
public class DoctorServiceApplication implements CommandLineRunner {

	@Autowired
	UserDetailsManager userDetailsManager;

	public static void main(String[] args) {
		SpringApplication.run(DoctorServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (!userDetailsManager.userExists("admin")) {
			userDetailsManager.createUser(
					User.withUsername("admin").password("{noop}admin").roles("ADMIN", "DOCTOR", "USER").build());
		}
		if (!userDetailsManager.userExists("user")) {
			userDetailsManager.createUser(
					User.withUsername("user").password("{noop}user").roles("USER").build());
		}
	}

}
