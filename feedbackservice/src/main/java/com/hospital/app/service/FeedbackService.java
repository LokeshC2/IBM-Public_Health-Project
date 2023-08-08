package com.hospital.app.service;

import java.util.List;

import com.hospital.app.model.Feedback;

public interface FeedbackService {
	
	public Feedback saveFeedback(Feedback feedback);
	public List<Feedback> getAllFeedback();
	public Feedback getFeedbackById(Long id);
	public void deleteFeedbackById(Long id);
}
