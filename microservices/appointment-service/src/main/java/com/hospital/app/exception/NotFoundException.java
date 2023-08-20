package com.hospital.app.exception;

public class NotFoundException extends RuntimeException{

  public NotFoundException(Exception e) {
    super("Appointment Not Found", e);
  }
  
}
