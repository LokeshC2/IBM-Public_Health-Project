package com.hospital.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hospital.app.model.Appointment;
import java.util.List;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
  @Query("SELECT a FROM Appointment a WHERE a.patient.id = ?1") 
	List<Appointment> findAllByPatientId(int patientId);
}
