package com.hospital.app.exception;

public class NotFoundException extends RuntimeException{

  public NotFoundException(Exception e) {
    super("Enquiry Not Found", e);
  }
  
}
