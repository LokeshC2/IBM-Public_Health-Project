import { Component } from '@angular/core';
import { Login } from './login';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { UserComponent } from '../user/user.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginDetails = new Login();

  constructor(private loginService: LoginService, private router: Router) { }

  validateLogin() {
    console.log(this.loginDetails);
    this.loginService.validateLogin(this.loginDetails).subscribe(data => {
      this.loginDetails = { ...this.loginDetails, ...data}
      if (this.loginDetails.loggedIn) {
        this.loginSuccess();
      }
      else {
        this.loginFailed();
      }
    });
  }

  loginFailed() {
    alert("Wrong Inputs!")
    console.log('failed');
  }

  loginSuccess() {
    if (this.loginDetails.role == "USER") {
      this.router.navigate(['/doctors', this.loginDetails.id]);
    }
    else if (this.loginDetails.role == "DOCTOR") {
      this.router.navigate(['/doctors', this.loginDetails.id]);
    }
    else if (this.loginDetails.role == "ADMIN") {
      this.router.navigate(['/amdin']);
    }
    else {
      this.router.navigate(['/login']);
    }
  }

}
