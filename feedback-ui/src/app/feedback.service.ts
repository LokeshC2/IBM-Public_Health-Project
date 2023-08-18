import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Feedback } from './feedback/feedback';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {


  private baseURL = "http://localhost:8085/feedbacks/"
  constructor(private httpClient:HttpClient) { }

  getAllFeedback(): Observable<Feedback[]>{
    return this.httpClient.get<Feedback[]>(`${this.baseURL}`);
  }

  saveFeedback(feedback: Feedback): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, feedback);
  }

  deleteFeedbackById(id:number):Observable<any>{
    return this.httpClient.delete(`${this.baseURL}${id}`, {responseType: 'text'});
  }

  getFeedbackById(id:string):Observable<any>{
    return this.httpClient.get(`${this.baseURL}${id}`);
  }
}
