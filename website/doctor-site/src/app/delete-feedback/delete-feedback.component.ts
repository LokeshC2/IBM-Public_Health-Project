import { Component } from '@angular/core';
import { FeedbackService } from '../feedback.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-delete-feedback',
  templateUrl: './delete-feedback.component.html',
  styleUrls: ['./delete-feedback.component.css']
})
export class DeleteFeedbackComponent {

  id:number=0;
  constructor(private feedbackService: FeedbackService,
    private router: Router) { }

    deleteFeedback(){
      this.feedbackService.deleteFeedbackById(this.id).subscribe(data=>{
        this.goToFeedbackList();
      },
      error=> console.log(error));
     
    }
    goToFeedbackList(){
      this.router.navigate(['/feedbacks']);
    }

    onSubmit(){
      console.log(this.id);
      this.deleteFeedback();
    }


}
