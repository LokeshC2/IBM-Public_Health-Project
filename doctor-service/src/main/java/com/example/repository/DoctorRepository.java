package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
