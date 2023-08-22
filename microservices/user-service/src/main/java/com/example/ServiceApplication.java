package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.entity.PatientRegistration;
import com.example.repository.PatientRegistrationRepository;

@SpringBootApplication
@EnableDiscoveryClient
@SuppressWarnings("PMD.UseUtilityClass")
public class ServiceApplication implements CommandLineRunner{

	@Autowired
	PatientRegistrationRepository patientRegistrationRepository;

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRegistrationRepository.save(new PatientRegistration(
				"Rahul",
				"Kumar",
				"x"+Math.floor(Math.random()*1000)+"@email.com",
				"123456"
		));
	}
}
