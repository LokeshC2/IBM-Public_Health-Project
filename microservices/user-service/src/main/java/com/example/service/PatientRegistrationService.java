package com.example.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.entity.PatientRegistration;
import com.example.ui.PatientRegistrationDto;

public interface PatientRegistrationService {

	List<PatientRegistration> getPatientRegistrations();

	PatientRegistration savePatientRegistration(PatientRegistration thePatientRegistration);

	PatientRegistrationDto getPatientRegistrationById(String id);

	int deletePatientRegistrationById(String id);

	PatientRegistration updatepatientregistration(String id, PatientRegistration patient);

	UserDetails validateLogin(String userId, String password);

}
