package com.hospital.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.app.exception.InvalidTimeException;
import com.hospital.app.exception.NotFoundException;
import com.hospital.app.model.Appointment;
import com.hospital.app.repository.AppointmentRepository;

@Service
public class AppointmentService {

  @Autowired
  private AppointmentRepository appointmentRepository;

  public Appointment saveAppointment(Appointment appointment) {
    return appointmentRepository.save(appointment);
  }

  public List<Appointment> getAllAppointments() {
    return appointmentRepository.findAll();
  }

  public List<Appointment> getAppointmentByPatientId(int id) {
    return appointmentRepository.findByPatientId(id);
  }

  public void deleteAppointmentById(Long id) {
    appointmentRepository.deleteById(id);
  }

  public void updateAppointment(Appointment appointment) throws NotFoundException, InvalidTimeException {
    if (!appointment.isValid()) {
      throw new InvalidTimeException();
    }
    try {
      Appointment app = appointmentRepository.findById(appointment.getId()).get();
      if (appointment.getSlotStart() != null) {
        app.setSlotStart(appointment.getSlotStart());
      }
      if (appointment.getSlotEnd() != null) {
        app.setSlotEnd(appointment.getSlotEnd());
      }
    } catch (Exception e) {
      throw new NotFoundException(e);
    }
    appointmentRepository.flush();
  }
}
