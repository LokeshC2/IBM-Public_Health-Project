package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Doctor;
import com.example.exception.CallException;
import com.example.service.DoctorService;


@RestController
@RequestMapping("/api/doctors")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:9999", "https://ibm.lokeshc2.me/"})
public class DoctorController {
	
		@Autowired
		private DoctorService doctorService;
	
	    @GetMapping("/list")
	    public List<Doctor> findAll(){
	        return doctorService.getDoctors();
	    }
		
		@PostMapping("/register")
	    public Doctor createDoctorById(@RequestBody Doctor doctor){
	        return doctorService.saveDoctor(doctor);
	    }

	    @GetMapping("/{id}")
	    public Optional<Doctor> findDoctorById(@PathVariable int id) throws CallException{
	    	
	    	Optional<Doctor> doctor = doctorService.getDoctorById(id);
			if(doctor.isEmpty()) {
				throw new CallException("Doctor with id #"+id+" don't exist.");
			}
			else {
				return doctor;
			}
	    }

	    @PutMapping("/update/{id}")
	    public Doctor updateDoctorById(@RequestBody Doctor doctor, @PathVariable int id) throws CallException{
	    	
	        Doctor dc =  doctorService.updateDoctor(doctor,id);
	        if(dc==null) {
	        	throw new CallException("No record found.");
	        }
	        else {
	        	return dc;
	        }
	    }

	    @DeleteMapping("/{id}")
	    public boolean deleteDoctorById(@PathVariable int id) throws CallException {
	         boolean check= doctorService.deleteDoctorById(id);
	         if(!check) {
	        	 throw new CallException("No record found.");
	         }
	         else {
	        	 return check;
	         }
	    }
}
