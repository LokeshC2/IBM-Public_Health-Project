package com.example.service;

import java.util.List;

import com.example.entity.Payment;

public interface PaymentService {

	Payment savePayment(Payment payment);

	List<Payment> getAllPayments();
	
	Payment getPaymentByAppointmentId(Long appId);

	Payment getPaymentById(int id);

	boolean deletePaymentById(int id) ;
}
