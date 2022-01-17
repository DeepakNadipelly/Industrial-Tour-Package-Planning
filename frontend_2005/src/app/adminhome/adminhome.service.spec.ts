import { TestBed, inject } from '@angular/core/testing';

import { AdminhomeService } from './adminhome.service';

describe('AdminhomeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdminhomeService]
    });
  });

  it('should be created', inject([AdminhomeService], (service: AdminhomeService) => {
    expect(service).toBeTruthy();
  }));
});
