package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.example.entity.PatientRegistration;
import com.example.repository.PatientRegistrationRepository;
import com.example.ui.PatientRegistrationDto;

@Service
public class PatientRegistrationServiceImpl implements PatientRegistrationService {

	@Autowired
	PatientRegistrationRepository patientRegistrationRepository;

	@Autowired
	UserDetailsManager userDetailsManager;

	@Override
	public List<PatientRegistration> getPatientRegistrations() {

		return patientRegistrationRepository.findAll();
	}

	@Override
	public PatientRegistration savePatientRegistration(PatientRegistration thePatientRegistration) {
		PatientRegistration patientStatus = patientRegistrationRepository.findByEmail(thePatientRegistration.getEmail());
		if (patientStatus != null) {
			return null;
		}
		String username = thePatientRegistration.getEmail();

		if (userDetailsManager.userExists(username)) {
			userDetailsManager.updateUser(
					User.withUsername(username)
							.password(thePatientRegistration.getPassword())
							.authorities(userDetailsManager.loadUserByUsername(username).getAuthorities())
							.roles("PATIENT").build());
		} else {
			userDetailsManager.createUser(
					User.withUsername(username)
							.password(thePatientRegistration.getPassword())
							.roles("PATIENT").build());
		}

		return patientRegistrationRepository.save(thePatientRegistration);
	}

	@Override
	public PatientRegistrationDto getPatientRegistrationById(String id) {
		Optional<PatientRegistration> temp = patientRegistrationRepository.findById(id);
		if (temp.isEmpty()) {
			return null;
		} else {
			PatientRegistration tempPatient = temp.get();
			return new PatientRegistrationDto(tempPatient.getFirstName(),
					tempPatient.getLastName(), tempPatient.getEmail(), tempPatient.getDateOfBirth(), tempPatient.getAge(),
					tempPatient.getGender(), tempPatient.getAddress(), tempPatient.getCity(), tempPatient.getState(),
					tempPatient.getPincode(), tempPatient.getPhone());
		}

	}

	@Override
	public int deletePatientRegistrationById(String id) {
		Optional<PatientRegistration> patient = patientRegistrationRepository.findById(id);
		if (patient.isEmpty()) {
			return 0;
		} else {
			patientRegistrationRepository.deleteById(id);
			userDetailsManager.deleteUser(patient.get().getEmail());
			return 1;
		}

	}

	@Override
	public PatientRegistration updatepatientregistration(String id, PatientRegistration patient) {
		PatientRegistration patientUpdate = patientRegistrationRepository.findByUserId(id);
		if (patientUpdate == null) {
			return null;
		} else {
			patientUpdate.setEmail(patient.getEmail());
			patientUpdate.setPhone(patient.getPhone());
			patientUpdate.setPassword(patient.getPassword());
			return patientRegistrationRepository.save(patientUpdate);
		}
	}

	@Override
	public UserDetails validateLogin(String userId, String password) {
		PatientRegistration patientRegistration = patientRegistrationRepository.findByUserId(userId);

		if (patientRegistration != null && patientRegistration.getPassword().equals(password)) {
			return userDetailsManager.loadUserByUsername(patientRegistration.getEmail());
		} else {
			return null;
		}
	}

}
