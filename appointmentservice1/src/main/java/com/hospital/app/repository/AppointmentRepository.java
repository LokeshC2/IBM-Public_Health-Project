package com.hospital.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.app.model.Appointment;
import java.util.List;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
   
	List<Appointment> findByPatientId(int patientId);
}
