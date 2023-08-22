import { Component, Injectable, Input } from '@angular/core';
import { Login } from '../login/login';

@Injectable({
  providedIn: 'root'
})

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css']
})
export class DoctorListComponent {
  @Input() doctors: any[];
  @Input() loginDetails: Login;

  constructor() {
    this.doctors = [];
    this.loginDetails = new Login();
  }
}
