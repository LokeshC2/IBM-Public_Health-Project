package com.example.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Payment;
import com.example.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public Payment savePayment(Payment payment) {
		if(payment.getAppointmentId()!=null && payment.getAccount()!=null) {
			payment.setTxnId(UUID.randomUUID());
			payment.setPaymentDate(new Date());
			payment.setPaymentStatus(true);
			paymentRepository.save(payment);
			
		}
		return payment;
	}

	@Override
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment getPaymentByAppointmentId(Long appId) {
		List<Payment> tempPayment= paymentRepository.findByAppointmentId(appId);
		if(tempPayment.isEmpty()) {
		return null;
		}
		else {
			return tempPayment.get(0);
		}
	}

	@Override
	public Payment getPaymentById(int id) {
		Optional<Payment> payment = paymentRepository.findById(id);
		if(payment.isEmpty()) {
			return null;
		}
		else {
			return payment.get();
		}
	}

	@Override
	public boolean deletePaymentById(int id) {
		Optional<Payment> payment = paymentRepository.findById(id);
				if(payment.isPresent()) {
			
					paymentRepository.deleteById(id);
					return true;
				}
		return false;
	}

}
