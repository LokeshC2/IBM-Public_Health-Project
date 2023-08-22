package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Payment;
import com.example.exception.CallException;
import com.example.service.PaymentService;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;

	@PostMapping
	public Payment savePayment(@RequestBody Payment payment) {
		
		return paymentService.savePayment(payment);	
	}
	
	@GetMapping("/appointment/{appId}")
	public Payment findByAppointId(@PathVariable Long appId) throws CallException {
		Payment payment = paymentService.getPaymentByAppointmentId(appId);
		if(payment==null) {
        	throw new CallException("No record found.");
        }
        else {
        	return payment;
        }
	}
	
	@GetMapping("/{id}")
	public Payment findById(@PathVariable int id) throws CallException {
		Payment payment = paymentService.getPaymentById(id);
		if(payment==null) {
        	throw new CallException("No record found.");
        }
        else {
        	return payment;
        }
	}
	
	@GetMapping
	public List<Payment> findAll(){
		return paymentService.getAllPayments();
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable int id) {
		return paymentService.deletePaymentById(id);
		
	}
}
