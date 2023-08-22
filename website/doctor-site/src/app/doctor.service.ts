import { Injectable } from '@angular/core';
import { DoctorRegistration } from './doctor-registration/doctor-registration';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Doctor } from './doctor-list/doctor';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  doctor = new Doctor();

  // private baseURL = 'http://192.168.226.87:9999/doctor-service/api/doctors';
  private baseURL = 'http://192.168.226.87:4211/api/doctors';

  constructor(
    private http: HttpClient,
    private loginService: LoginService,
  ) { }

  registerDoctor(doctor: DoctorRegistration) {
    return this.loginService.registerDoctor(doctor).subscribe(data => {
      this.doctor = data;
      return new Observable<Doctor>(observer => {
        observer.next(this.doctor);
      });
    });
  }

  getAllDoctors(): Observable<Doctor[]> {
    return this.http.get<Doctor[]>(this.baseURL + "/list");
  }
}
