import { Component } from '@angular/core';
import { Feedback } from './feedback';
import { FeedbackService } from '../feedback.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent {

  feedback:Feedback =new Feedback();
  constructor(private feedbackService: FeedbackService,
    private router: Router) { }

    saveFeedback(){
      this.feedbackService.saveFeedback(this.feedback).subscribe(data=>{
        this.goToFeedbackList();
      },
      error => console.log(error));
      
    }

goToFeedbackList(){
  console.log(this.feedback);
  this.router.navigate(['/feedbacks']);
}
onSubmit() {
 console.log(this.feedback);
 this.saveFeedback();
}

}
