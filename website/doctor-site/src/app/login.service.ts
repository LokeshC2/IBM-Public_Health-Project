import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Login } from './login/login';
import { User } from './user/User';
import { Signup } from './signup/signup';
import { Doctor } from './doctor-list/doctor';
import { DoctorRegistration } from './doctor-registration/doctor-registration';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  // private patientBaseURL = "http://192.168.226.87:9999/user-service/api/users/";
  private patientBaseURL = "http://192.168.226.87:4233/api/users/";
  // private doctorBaseURL = "http://192.168.226.87:9999/doctor-service/api/doctors/";
  private doctorBaseURL = "http://192.168.226.87:4211/api/doctors/";
  constructor(private httpClient: HttpClient) { }

  validateLogin(loginDetails: Login): Observable<Login> {
    if (loginDetails.role == "USER") {
      return this.httpClient.post<Login>(`${this.patientBaseURL + 'login'}`, loginDetails);
    }
    else if (loginDetails.role == "DOCTOR") {
      return this.httpClient.post<Login>(`${this.doctorBaseURL + 'login'}`, loginDetails);
    }
    else {
      if (loginDetails.username == "admin" && loginDetails.password == "admin") {
        loginDetails.loggedIn = true;
        loginDetails.role = "ADMIN";
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
    return this.httpClient.get<User>(`${this.patientBaseURL + '/' + id}`);
  }

  registerUser(user: Signup): Observable<User> {
    return this.httpClient.post<User>(`${this.patientBaseURL + 'register'}`, user);
  }

  getDoctor(id: string): Observable<Doctor> {
    return this.httpClient.get<Doctor>(`${this.doctorBaseURL + '/' + id}`);
  }

  registerDoctor(doctor: DoctorRegistration): Observable<Doctor> {
    return this.httpClient.post<Doctor>(`${this.doctorBaseURL + 'register'}`, doctor);
  }
}
