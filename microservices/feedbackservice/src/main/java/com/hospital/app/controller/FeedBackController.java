package com.hospital.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.app.exception.NotFoundException;
import com.hospital.app.model.Feedback;
import com.hospital.app.service.FeedbackServiceImpl;

@RestController
@RequestMapping("/feedbacks")
@CrossOrigin("http://localhost:4200")
public class FeedBackController {
	@Autowired
	private FeedbackServiceImpl feedbackService;
	
	@PostMapping
	public ResponseEntity<Feedback> saveFeedback(@RequestBody Feedback feedback){
		return ResponseEntity.ok(feedbackService.saveFeedback(feedback));
	}
	
	@GetMapping()
	public ResponseEntity<List<Feedback>> getAllFeedback(){
		return ResponseEntity.ok(feedbackService.getAllFeedback());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id){
		return ResponseEntity.ok(feedbackService.getFeedbackById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFeedbackById(@PathVariable Long id){
		feedbackService.deleteFeedbackById(id);
		return ResponseEntity.ok("");
	}
	
	@ExceptionHandler(NotFoundException.class)
	  public ResponseEntity<?> handleException(NotFoundException e) {
	    return ResponseEntity.badRequest().body(e.getMessage());
	}
}
