package com.hospital.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.app.model.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {
  
}
