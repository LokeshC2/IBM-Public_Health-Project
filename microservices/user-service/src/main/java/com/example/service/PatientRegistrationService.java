package com.example.service;

import java.util.List;

import com.example.entity.PatientRegistration;
import com.example.ui.LoginResponseDto;
import com.example.ui.PatientRegistrationDto;

public interface PatientRegistrationService {

	List<PatientRegistration> getPatientRegistrations();

	PatientRegistration savePatientRegistration(PatientRegistration thePatientRegistration);

	PatientRegistrationDto getPatientRegistrationById(String id);

	int deletePatientRegistrationById(String id);

	PatientRegistration updatepatientregistration(String id, PatientRegistration patient);

	LoginResponseDto validateLogin(String username, String password);

}
