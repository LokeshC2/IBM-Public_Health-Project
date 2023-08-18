import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FeedbackListComponent } from './feedback-list/feedback-list.component';
import { DeleteFeedbackComponent } from './delete-feedback/delete-feedback.component';
import { FindFeedbackByIdComponent } from './find-feedback-by-id/find-feedback-by-id.component';

@NgModule({
  declarations: [
    AppComponent,
    FeedbackComponent,
    FeedbackListComponent,
    DeleteFeedbackComponent,
    FindFeedbackByIdComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
