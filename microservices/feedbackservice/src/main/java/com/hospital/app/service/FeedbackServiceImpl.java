package com.hospital.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.app.model.Feedback;
import com.hospital.app.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Override
	public Feedback saveFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}
	
	@Override
	public List<Feedback> getAllFeedback() {
		return feedbackRepository.findAll();
	}
	
	@Override
	public Feedback getFeedbackById(Long id) {
		return feedbackRepository.findById(id).get();
	}
	
	@Override
	public void deleteFeedbackById(Long id) {
		feedbackRepository.deleteById(id);
	}

}
