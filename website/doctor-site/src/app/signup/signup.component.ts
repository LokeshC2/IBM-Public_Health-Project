import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { Signup } from './signup';
import { Doctor } from '../doctor-list/doctor';
import { DoctorRegistration } from '../doctor-registration/doctor-registration';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  user = new Signup();
  doctor = new DoctorRegistration();
  role: "USER" | "DOCTOR" | "" = "";

  constructor(private loginService: LoginService, private router: Router) { }

  registerUser() {
    this.loginService.registerUser(this.user).subscribe(data => {
      console.log(data)
      this.router.navigate(["/login"]);
      alert("Registration Done")
    });
  }

  registerDoctor() {
    this.loginService.registerDoctor(this.doctor).subscribe(data => {
      console.log(data)
      this.router.navigate(["/login"]);
      alert("Registration Done")
    });
  }

  onSubmitUser() {
    this.registerUser();
  }

  onSubmitDoctor() {
    this.registerDoctor();
  }

  onSubmitRole() {
    window.location.reload();
  }

}
