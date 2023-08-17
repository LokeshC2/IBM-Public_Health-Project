import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Login } from './login/login';
import { LoginValidation } from './login/login-validation';
import { User } from './user/user';
import { Signup } from './signup/signup';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  sharedData = new User();

  private baseURL = "http://localhost:8001/users/"
  constructor(private httpClient:HttpClient) { }

  validateLogin(loginDetails: Login): Observable<LoginValidation>{
    return this.httpClient.post<LoginValidation>(`${this.baseURL+'login'}`,loginDetails);
  }

  getUser(id:number): Observable<User>{
    return this.httpClient.get<User>(`${this.baseURL+'patient/'+id}`)
}

registerUser(user: Signup): Observable<Object>{
  return this.httpClient.post(`${this.baseURL+'register'}`,user);
}


}
