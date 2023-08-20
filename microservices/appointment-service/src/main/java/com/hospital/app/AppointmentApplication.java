package com.hospital.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@SuppressWarnings("PMD.UseUtilityClass")
public class AppointmentApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(AppointmentApplication.class, args);
  }

}
