package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Payment;
import java.util.List;


public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	List<Payment> findByAppointmentId(Long appointmentId);
}
