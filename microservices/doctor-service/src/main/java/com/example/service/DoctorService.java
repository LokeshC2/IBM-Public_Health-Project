package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.Doctor;

public interface DoctorService {
	List<Doctor> getDoctors();

	Doctor saveDoctor(Doctor doctor);

	Optional<Doctor> getDoctorById(String id);

	boolean deleteDoctorById(String id);

	Doctor updateDoctor(Doctor doctor, String id);

  boolean validateLogin(String username, String password);
}
