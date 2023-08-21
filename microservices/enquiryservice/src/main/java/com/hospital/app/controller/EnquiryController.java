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
import com.hospital.app.model.Enquiry;
import com.hospital.app.service.EnquiryService;

@RestController
@RequestMapping("/enquiries")
@CrossOrigin(origins = "*")
public class EnquiryController {

  @Autowired
  private EnquiryService enquiryService;
  
  @GetMapping
  public ResponseEntity<List<Enquiry>> getAllEnquiries() {
    return ResponseEntity.ok(enquiryService.getAllEnquiries());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Enquiry> getEnquiryById(@PathVariable Long id) {
    return ResponseEntity.ok(enquiryService.getEnquiryById(id));
  }

  @PostMapping
  public ResponseEntity<Enquiry> saveEnquiry(@RequestBody Enquiry enquiry) {
    return ResponseEntity.ok(enquiryService.saveEnquiry(enquiry));
  }

  @PostMapping("/{id}/answer")
  public ResponseEntity<?> addAnswer(@PathVariable Long id, @RequestBody String answer) {
    enquiryService.addAnswer(id, answer);
    return ResponseEntity.ok("");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteEnquiryById(@PathVariable Long id) {
    enquiryService.deleteEnquiryById(id);
    return ResponseEntity.ok("");
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<?> handleException(NotFoundException e) {
    return ResponseEntity.badRequest().body(e.getMessage());
  }
}
