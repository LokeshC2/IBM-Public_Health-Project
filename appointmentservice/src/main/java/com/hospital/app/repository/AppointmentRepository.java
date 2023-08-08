package com.hospital.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.app.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
  
}
