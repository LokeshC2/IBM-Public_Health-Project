import { Component, Injectable, Input, OnInit } from '@angular/core';
import { Login } from '../login/login';
import { Doctor } from './doctor';
import { DoctorService } from '../doctor.service';

@Injectable({
  providedIn: 'root'
})

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css']
})
export class DoctorListComponent {
  @Input() loginDetails: Login;

  doctors: Doctor[];

  constructor(doctorService: DoctorService) {
    this.doctors = [];
    this.loginDetails = new Login();
    doctorService.getAllDoctors().subscribe(data => {
      this.doctors = data;
    })
  }
}
