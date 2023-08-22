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

  constructor(private loginService:LoginService,private router:Router,private user:UserComponent) {}


     validateLogin(){
      this.loginService.validateLogin(this.loginDetails).subscribe(data =>{
        this.loginDetails = data;
        if(this.loginDetails.loggedIn){
          this.loginSuccess();
        }
        else{
          this.loginFailed();
        }
      });
    }

    loginFailed(){
      alert("Wrong Inputs!")
      console.log('failed');
    }

    loginSuccess(){
      this.user.getUser(this.loginDetails.userId);
      // setTimeout(() => {
        this.router.navigate(["/user"]);
      // }, 400);

      console.log('success');
    }

     onSubmit(){
      this.validateLogin();
     }

}
