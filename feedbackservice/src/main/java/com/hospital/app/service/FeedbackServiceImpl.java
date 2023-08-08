package com.hospital.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.app.model.Feedback;
import com.hospital.app.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedbackRepository FeedbackRepository;
	
	@Override
	public Feedback saveFeedback(Feedback feedback) {
		return FeedbackRepository.save(feedback);
	}
	
	@Override
	public List<Feedback> getAllFeedback() {
		return FeedbackRepository.findAll();
	}
	
	@Override
	public Feedback getFeedbackById(Long id) {
		return FeedbackRepository.findById(id).get();
	}
	
	@Override
	public void deleteFeedbackById(Long id) {
		FeedbackRepository.deleteById(id);
	}

}
