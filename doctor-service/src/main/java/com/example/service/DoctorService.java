package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.Doctor;


	public interface DoctorService {
	List<Doctor> getDoctors();
	Doctor saveDoctor(Doctor doctor);
	Optional<Doctor> getDoctorById(int id);
	boolean deleteDoctorById(int id);
	Doctor updateDoctor(Doctor doctor, int id) ;
}
