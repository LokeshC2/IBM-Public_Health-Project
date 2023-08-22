import { DoctorRegistration } from './doctor-registration';

describe('DoctorRegistration', () => {
  it('should create an instance', () => {
    expect(new DoctorRegistration(
      null,                 // Id
      '',                   // First Name
      '',                   // Last Name
      '',                   // Specialist
      '',                   // Branch
      '',                   // Photo
      0,                    // Fee
    )).toBeTruthy();
  });
});
