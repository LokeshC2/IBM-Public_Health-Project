package com.hospital.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.app.exception.InvalidTimeException;
import com.hospital.app.exception.NotFoundException;
import com.hospital.app.model.Appointment;
import com.hospital.app.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

  @Autowired
  private AppointmentService appointmentService;
  
  @GetMapping
  public ResponseEntity<List<Appointment>> getAllAppointments() {
    return ResponseEntity.ok(appointmentService.getAllAppointments());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
    return ResponseEntity.ok(appointmentService.getAppointmentById(id));
  }

  @PostMapping
  public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment) {
    return ResponseEntity.ok(appointmentService.saveAppointment(appointment));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment) throws NotFoundException, InvalidTimeException {
    appointmentService.updateAppointment(appointment);
    return ResponseEntity.ok(appointment);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteAppointmentById(@PathVariable Long id) {
    appointmentService.deleteAppointmentById(id);
    return ResponseEntity.ok("");
  }

  @GetMapping("/patient/{id}")
  public ResponseEntity<Appointment> getAppointmentsByPatientId(@PathVariable Long id) {
    return ResponseEntity.ok(appointmentService.getAppointmentById(id));
  }

  @GetMapping("/doctor/{id}")
  public ResponseEntity<Appointment> getAppointmentsByDoctorId(@PathVariable Long id) {
    return ResponseEntity.ok(appointmentService.getAppointmentById(id));
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<?> handleException(NotFoundException e) {
    return ResponseEntity.badRequest().body(e.getMessage());
  }
}
