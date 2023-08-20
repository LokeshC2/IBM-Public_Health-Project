package com.example.service;

import java.util.List;			
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.PatientRegistration;
import com.example.repository.PatientRegistrationRepository;
import com.example.ui.LoginValidation;
import com.example.ui.PatientRegistrationDto;

@Service
public class PatientRegistrationServiceImpl implements PatientRegistrationService{
	
	@Autowired
	PatientRegistrationRepository patientRegistrationRepository;
	
	@Override
	public List<PatientRegistration> getPatientRegistrations() {
		
		return patientRegistrationRepository.findAll();
	}
	
	@Override
	public PatientRegistration savePatientRegistration(PatientRegistration thePatientRegistration) {
		PatientRegistration patientStatus= patientRegistrationRepository.findByEmail(thePatientRegistration.getEmail());
		if(patientStatus ==null) {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
		         + "0123456789"
		         + "abcdefghijklmnopqrstuvxyz";
		  // create StringBuffer size of AlphaNumericString
		  StringBuilder sb = new StringBuilder(7);
		  for (int i = 0; i < 7; i++) {
		   // generate a random number between
		   // 0 to AlphaNumericString variable length
		   int index= (int)(AlphaNumericString.length()* Math.random());
		   // add Character one by one in end of sb
		   sb.append(AlphaNumericString.charAt(index));
		  }
		  String userId =  sb.toString();
		thePatientRegistration.setUserId(userId);
		return patientRegistrationRepository.save(thePatientRegistration);
		}
		else return null;
	}

	@Override
	public PatientRegistrationDto getPatientRegistrationById(int id) {
		// TODO Auto-generated method stub
		Optional<PatientRegistration> temp =  patientRegistrationRepository.findById(id);
		if(temp.isEmpty()) {
			return null;
		}
		else {
		PatientRegistration tempPatient = temp.get();
		PatientRegistrationDto patientDto = new PatientRegistrationDto(tempPatient.getFirstName(), tempPatient.getLastName(), tempPatient.getEmail(), tempPatient.getDateOfBirth(), tempPatient.getAge(), tempPatient.getGender(), tempPatient.getAddress(), tempPatient.getCity(), tempPatient.getState(), tempPatient.getPincode(), tempPatient.getPhone());
		return patientDto;
		}

	}

	@Override
	public int deletePatientRegistrationById(int id) {
		Optional<PatientRegistration> patient = patientRegistrationRepository.findById(id);
		if (patient.isEmpty()) {
			return 0;
		}
		else {
			patientRegistrationRepository.deleteById(id);
			return 1;
		}

		
	}

	@Override
	public PatientRegistration updatepatientregistration(String id, PatientRegistration patient) {
		PatientRegistration patientUpdate= patientRegistrationRepository.findByUserId(id);
		if (patientUpdate==null) {
			return null;
		}
		else {
		patientUpdate.setEmail(patient.getEmail());
		patientUpdate.setPhone(patient.getPhone());
		patientUpdate.setPassword(patient.getPassword());
		return   patientRegistrationRepository.save(patientUpdate);
		}
	}

	@Override
	public LoginValidation validateLogin(String userId, String password) {
		PatientRegistration patientRegistration = patientRegistrationRepository.findByUserId(userId);
		LoginValidation loginValidation = new LoginValidation();
		if(patientRegistration!=null)
		{
			
			if(patientRegistration.getPassword().equals(password))
	    	{	
	    		 loginValidation.setLoginStatus(true);
	    		 loginValidation.setId(patientRegistration.getPatient_id());
	    	}
	    	else
	    	{
	    		 loginValidation.setLoginStatus(false);
	    	}	
		}
		return loginValidation;
	}	

}
