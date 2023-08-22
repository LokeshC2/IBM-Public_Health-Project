package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Doctor;
import com.example.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public List<Doctor> getDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public Optional<Doctor> getDoctorById(String id) {

		return doctorRepository.findById(id);
	}

	@Override
	public Doctor updateDoctor(Doctor tempDoctor, String id) {
		Optional<Doctor> opDoctor = doctorRepository.findById(id);
		if (opDoctor.isEmpty()) {
			return null;
		} else {
			Doctor doctor = opDoctor.get();
			doctor.setPhoto(tempDoctor.getPhoto());
			doctor.setFee(tempDoctor.getFee());
			return doctorRepository.save(doctor);
		}
	}

	@Override
	public boolean deleteDoctorById(String id) {
		Optional<Doctor> patient = getDoctorById(id);
		if (patient.isEmpty()) {
			return false;
		} else {
			doctorRepository.deleteById(id);
			return true;
		}

	}

	@Override
	public boolean validateLogin(String username, String password) {
		Optional<Doctor> d = doctorRepository.findByEmailId(username);
		return d.isPresent() && d.get().getPassword().equals(password);
	}

}
