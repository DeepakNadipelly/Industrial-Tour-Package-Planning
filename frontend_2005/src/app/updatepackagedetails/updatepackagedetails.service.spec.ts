import { TestBed, inject } from '@angular/core/testing';

import { UpdatepackagedetailsService } from './updatepackagedetails.service';

describe('UpdatepackagedetailsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UpdatepackagedetailsService]
    });
  });

  it('should be created', inject([UpdatepackagedetailsService], (service: UpdatepackagedetailsService) => {
    expect(service).toBeTruthy();
  }));
});
