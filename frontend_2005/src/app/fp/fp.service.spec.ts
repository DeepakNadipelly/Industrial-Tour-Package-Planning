import { TestBed, inject } from '@angular/core/testing';

import { FpService } from './fp.service';

describe('FpService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FpService]
    });
  });

  it('should be created', inject([FpService], (service: FpService) => {
    expect(service).toBeTruthy();
  }));
});
