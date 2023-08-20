package com.hospital.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.app.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
  
}
