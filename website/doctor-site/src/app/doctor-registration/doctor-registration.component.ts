import { Component } from '@angular/core';
import { DoctorRegistration } from './doctor-registration';
import { NgForm } from '@angular/forms';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-doctor-registration',
  templateUrl: './doctor-registration.component.html',
  styleUrls: ['./doctor-registration.component.css']
})
export class DoctorRegistrationComponent {

  constructor(private doctorService: DoctorService) {
  }

  doctor = new DoctorRegistration();

  onSubmit() {
    let response = this.doctorService.registerDoctor(this.doctor)
    if (response) {
      console.log("Doctor registered successfully");
      window.location.href = "/login";
    } else {
      console.log("Doctor registration failed");
      window.location.href = "/doctor-registration";
    }
  }
}
