import { Component } from '@angular/core';
import { DoctorRegistration } from './doctor-registration';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-doctor-registration',
  templateUrl: './doctor-registration.component.html',
  styleUrls: ['./doctor-registration.component.css']
})
export class DoctorRegistrationComponent {

  submission_url = "http://localhost:9999/doctor-service/api/doctors/register";
  // submission_url = "http://localhost:8085/api/doctors/register";
  // submission_url = "http://localhost:3000/register";

  doctor = new DoctorRegistration();

  onSubmit() {
    fetch(this.submission_url, {
      method: 'POST',
      body: JSON.stringify(this.doctor),
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(response => {
      if (response.ok) {
        alert('Success!');
      } else {
        alert('Failure!');
      }
    });
  }
}
