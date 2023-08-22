package com.example.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.entity.PatientRegistration;
import com.example.ui.PatientRegistrationDto;

public interface PatientRegistrationService {

	public List<PatientRegistration> getPatientRegistrations();

	public PatientRegistration savePatientRegistration(PatientRegistration thePatientRegistration);

	public PatientRegistrationDto getPatientRegistrationById(int id);

	public int deletePatientRegistrationById(int id);

	public PatientRegistration updatepatientregistration(String id, PatientRegistration patient);

	public UserDetails validateLogin(String userId, String password);

}
