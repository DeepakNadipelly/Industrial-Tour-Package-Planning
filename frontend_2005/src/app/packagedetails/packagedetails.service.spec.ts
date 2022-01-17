import { TestBed, inject } from '@angular/core/testing';

import { PackagedetailsService } from './packagedetails.service';

describe('PackagedetailsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PackagedetailsService]
    });
  });

  it('should be created', inject([PackagedetailsService], (service: PackagedetailsService) => {
    expect(service).toBeTruthy();
  }));
});
