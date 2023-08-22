package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.PatientRegistration;


public interface PatientRegistrationRepository extends JpaRepository<PatientRegistration, Integer>{
	@Query("select u from PatientRegistration u where u.email = ?1")
	Optional<PatientRegistration> findByUserId(String userId);
	@Query("select u from PatientRegistration u where u.email = ?1")
	Optional<PatientRegistration> findByEmail(String email);
}
