import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { SignupComponent } from './signup/signup.component';
import { EnquireComponent } from './enquire/enquire.component';
import { DoctorListComponent } from './doctor-list/doctor-list.component';
import { DoctorRegistrationComponent } from './doctor-registration/doctor-registration.component';
import { DeleteFeedbackComponent } from './delete-feedback/delete-feedback.component';
import { FeedbackListComponent } from './feedback-list/feedback-list.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { FindFeedbackByIdComponent } from './find-feedback-by-id/find-feedback-by-id.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'about', component: AboutComponent },
  { path: 'login', component: LoginComponent },
  { path: 'user/:id', component: UserComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'enquire', component: EnquireComponent },
  { path: 'doctors', component: DoctorListComponent },
  { path: 'doctors/register', component: DoctorRegistrationComponent },
  { path: 'feedback', component: FeedbackComponent},
  { path: 'feedback/feedbacks', component: FeedbackListComponent },
  { path: 'feedback/create-feedback', redirectTo: 'feedback', pathMatch: 'full' },
  { path: 'feedback/delete-feedback', component: DeleteFeedbackComponent },
  { path: 'feedback/find-feedback', component: FindFeedbackByIdComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
