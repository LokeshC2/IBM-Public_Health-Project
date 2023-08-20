import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { Signup } from './signup';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  user = new Signup();

  constructor(private loginService:LoginService,private router:Router) {}

  registerUser(){
    this.loginService.registerUser(this.user).subscribe(data =>{
      console.log(data)
      this.router.navigate(["/login"]);
      alert("Registration Done")
    });
  }

  onSubmit(){
    this.registerUser();
   }

}
