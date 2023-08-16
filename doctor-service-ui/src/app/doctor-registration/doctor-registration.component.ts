import { Component } from '@angular/core';
import { DoctorRegistration } from './doctor-registration';

@Component({
  selector: 'app-doctor-registration',
  templateUrl: './doctor-registration.component.html',
  styleUrls: ['./doctor-registration.component.css']
})
export class DoctorRegistrationComponent {

  submission_url = "http://localhost:9999/doctor-service/api/doctors/register";

  doctor = new DoctorRegistration(null,'','','','','',0)

  onSubmit() {
    fetch(this.submission_url, {
      method: 'POST',
      body: JSON.stringify(this.doctor),
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(response => {
      if (response.ok) {
        this.onSuccess();
      } else {
        this.onFailure();
      }
    });
  }

  onSuccess() {
    alert('Success!');
  }

  onFailure() {
    alert('Failure!');
  }

}
