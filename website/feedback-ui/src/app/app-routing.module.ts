import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FeedbackListComponent } from './feedback-list/feedback-list.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { DeleteFeedbackComponent } from './delete-feedback/delete-feedback.component';
import { FindFeedbackByIdComponent } from './find-feedback-by-id/find-feedback-by-id.component';

const routes: Routes = [
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
