import { Component } from '@angular/core';
import { Feedback } from '../feedback/feedback';
import { FeedbackService } from '../feedback.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-feedback-list',
  templateUrl: './feedback-list.component.html',
  styleUrls: ['./feedback-list.component.css']
})
export class FeedbackListComponent {

  feedback :Feedback[] =[];
  constructor(private feedbackService: FeedbackService,
    private router: Router) { }
 
    ngOnInit(): void{
      this.getFeedback();
    }

    private getFeedback(){
      this.feedbackService.getAllFeedback().subscribe( data=>{
        this.feedback=data;
      });
    }
}
