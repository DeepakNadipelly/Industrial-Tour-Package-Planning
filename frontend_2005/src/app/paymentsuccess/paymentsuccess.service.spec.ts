import { TestBed, inject } from '@angular/core/testing';

import { PaymentsuccessService } from './paymentsuccess.service';

describe('PaymentsuccessService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PaymentsuccessService]
    });
  });

  it('should be created', inject([PaymentsuccessService], (service: PaymentsuccessService) => {
    expect(service).toBeTruthy();
  }));
});
