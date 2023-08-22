import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindFeedbackByIdComponent } from './find-feedback-by-id.component';

describe('FindFeedbackByIdComponent', () => {
  let component: FindFeedbackByIdComponent;
  let fixture: ComponentFixture<FindFeedbackByIdComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FindFeedbackByIdComponent]
    });
    fixture = TestBed.createComponent(FindFeedbackByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
