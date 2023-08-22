import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Login } from './login/login';
import { User } from './user/User';
import { Signup } from './signup/signup';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private patientBaseURL = "http://localhost:9999/patient-service/patient/";
  private doctorBaseURL = "http://localhost:9999/doctor-service/doctor/";
  constructor(private httpClient: HttpClient) { }

  validateLogin(loginDetails: Login): Observable<Login> {
    if (loginDetails.role == "patient") {
      return this.httpClient.post<Login>(`${this.patientBaseURL + 'login'}`, loginDetails);
    }
    else if (loginDetails.role == "doctor") {
      return this.httpClient.post<Login>(`${this.doctorBaseURL + 'login'}`, loginDetails);
    }
    else {
      if (loginDetails.username == "admin" && loginDetails.password == "admin") {
        loginDetails.loggedIn = true;
        loginDetails.role = "admin";
        loginDetails.id = 0;
        return new Observable<Login>(observer => {
          observer.next(loginDetails);
        });
      }
      else {
        loginDetails.loggedIn = false;
        return new Observable<Login>(observer => {
          observer.next(loginDetails);
        });
      }
    }
  }

  getUser(id: string): Observable<User> {
    return this.httpClient.get<User>(`${this.patientBaseURL + id}`)
  }

  registerUser(user: Signup): Observable<Object> {
    return this.httpClient.post(`${this.patientBaseURL + 'register'}`, user);
  }

}
