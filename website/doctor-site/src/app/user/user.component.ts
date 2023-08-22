import { Component, Injectable, OnInit } from '@angular/core';
import { User } from './User';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit{
  user = new User();

  constructor(private loginService:LoginService,private router:Router) {}

  ngOnInit(): void{
    // this.getUser();
  }

  getUser(id:string){
    this.loginService.getUser(id).subscribe(data =>{
      this.user = data;
      console.log(this.user);
    });
  }
  }
