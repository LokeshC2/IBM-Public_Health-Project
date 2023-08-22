import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UserComponent } from './user/user.component';
import { SignupComponent } from './signup/signup.component';
import { EnquireComponent } from './enquire/enquire.component';
import { DoctorListComponent } from './doctor-list/doctor-list.component';
import { DoctorRegistrationComponent } from './doctor-registration/doctor-registration.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { FeedbackListComponent } from './feedback-list/feedback-list.component';
import { FindFeedbackByIdComponent } from './find-feedback-by-id/find-feedback-by-id.component';
import { DeleteFeedbackComponent } from './delete-feedback/delete-feedback.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    LoginComponent,
    UserComponent,
    SignupComponent,
    EnquireComponent,
    DoctorListComponent,
    DoctorRegistrationComponent,
    FeedbackComponent,
    FeedbackListComponent,
    DeleteFeedbackComponent,
    FindFeedbackByIdComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
