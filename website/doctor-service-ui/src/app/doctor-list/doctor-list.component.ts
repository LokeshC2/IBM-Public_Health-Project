import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css']
})
export class DoctorListComponent {
  @Input() doctors: any[];

  constructor() {
    this.doctors = [];
  }
}
