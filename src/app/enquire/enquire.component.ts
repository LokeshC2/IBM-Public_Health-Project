import { Component } from '@angular/core';
import { Enquire } from './enquire';
import { EnquireService } from '../enquire.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-enquire',
  templateUrl: './enquire.component.html',
  styleUrls: ['./enquire.component.css']
})
export class EnquireComponent {
  enquiryForm = new Enquire();

  constructor(private enquireService:EnquireService,private router:Router) {}

  registerEnquiry(){
    this.enquireService.registerEnquiry(this.enquiryForm).subscribe(data =>{
      console.log(data)
      this.router.navigate(["/home"]);
      alert("Response Submitted.")
    });
  }

  onSubmit(){
    this.registerEnquiry();
   }
}
