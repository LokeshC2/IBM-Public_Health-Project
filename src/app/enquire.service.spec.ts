import { TestBed } from '@angular/core/testing';

import { EnquireService } from './enquire.service';

describe('EnquireService', () => {
  let service: EnquireService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EnquireService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
