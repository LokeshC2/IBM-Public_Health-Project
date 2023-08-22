package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, String> {

  @Query("SELECT d FROM Doctor d WHERE d.emailId = ?1")
  Optional<Doctor> findByEmailId(String username);

}
