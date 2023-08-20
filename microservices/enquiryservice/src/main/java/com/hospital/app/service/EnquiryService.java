package com.hospital.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.app.exception.NotFoundException;
import com.hospital.app.model.Enquiry;
import com.hospital.app.repository.EnquiryRepository;

@Service
public class EnquiryService {

  @Autowired
  private EnquiryRepository enquiryRepository;

  public Enquiry saveEnquiry(Enquiry enquiry) {
    return enquiryRepository.save(enquiry);
  }

  public List<Enquiry> getAllEnquiries() {
    return enquiryRepository.findAll();
  }

  public Enquiry getEnquiryById(Long id) {
    return enquiryRepository.findById(id).get();
  }

  public void deleteEnquiryById(Long id) {
    enquiryRepository.deleteById(id);
  }

  public void addAnswer(Long id, String answer) {
    try{
      Enquiry enquiry = enquiryRepository.findById(id).get();
      enquiry.setAnswer(answer);
      enquiryRepository.flush();
    } catch (Exception e) {
      throw new NotFoundException(e);
    }
  }
  
}
