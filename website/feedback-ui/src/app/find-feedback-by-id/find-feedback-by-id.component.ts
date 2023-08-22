import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FeedbackService } from '../feedback.service';
import { Feedback } from '../feedback/feedback';

@Component({
  selector: 'app-find-feedback-by-id',
  templateUrl: './find-feedback-by-id.component.html',
  styleUrls: ['./find-feedback-by-id.component.css']
})
export class FindFeedbackByIdComponent {
  feedbacks: any;
  id:string='';
  constructor(private feedbackService: FeedbackService,
    private router: Router) { }
  

    findFeedback(id:string){
      this.feedbackService.getFeedbackById(this.id).subscribe(data=>{
        this.feedbacks=data;
        console.log(this.feedbacks);
        
      },
      error=> console.log(error));
     
    }
   
    

    onSubmit(){
      console.log(this.id);
      this.findFeedback(this.id);
    }

}
