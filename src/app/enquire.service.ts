import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Enquire } from './enquire/enquire';

@Injectable({
  providedIn: 'root'
})
export class EnquireService {

  private baseURL = "http://localhost:8002/enquiries"
  constructor(private httpClient:HttpClient) { }

  registerEnquiry(enquire:Enquire): Observable<object>{
    return this.httpClient.post<object>(`${this.baseURL}`,enquire);
  }

}
