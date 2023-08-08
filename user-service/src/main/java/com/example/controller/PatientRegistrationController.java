package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.PatientRegistration;
import com.example.exception.CallException;
import com.example.service.PatientRegistrationService;
import com.example.ui.PatientRegistrationDto;

@RestController
@RequestMapping("/api/users")
public class PatientRegistrationController {
	
	@Autowired
	PatientRegistrationService patientRegistrationService;
	
	@GetMapping("/list")
	 public List<PatientRegistration> findAll(){
		return patientRegistrationService.getPatientRegistrations();
	}
	
	@PostMapping("/register")
	 public PatientRegistration createPatientRegistration(@RequestBody PatientRegistration patientRegistration) throws CallException {
		PatientRegistration data =  patientRegistrationService.savePatientRegistration(patientRegistration);
		if (data==null) {
			throw new CallException("User with this email already exist.");
		}
		else {
		return data;
		}
	}
	
	@GetMapping("/patient/{id}")
	 public PatientRegistrationDto getPatientById(@PathVariable("id") int id) throws CallException {
		PatientRegistrationDto patient = patientRegistrationService.getPatientRegistrationById(id);
		if(patient==null) {
			throw new CallException("Patient Not Found.");
		}
		else {
			return patient;
		}
	    }
	
	@PutMapping("/patient/{userId}")
	 public PatientRegistration update(@PathVariable("userId") String userId, @RequestBody PatientRegistration user) throws CallException{
	    
	     PatientRegistration patient =  patientRegistrationService.updatepatientregistration(userId,user);
	     if(patient==null) {
	    	 throw new CallException("Patient Not Found.");
	     }
	     else {
	    	 return patient;
	     }
	    }
	
	@DeleteMapping("/patient/{id}")
	 public boolean delete(@PathVariable("id") int id) throws CallException {
	         int check = patientRegistrationService.deletePatientRegistrationById(id);
	         if(check == 0) {
	        	 throw new CallException("Patient Don't Exist");
	         }
	         else {
	        	 return true;
	         }
	    }

}
