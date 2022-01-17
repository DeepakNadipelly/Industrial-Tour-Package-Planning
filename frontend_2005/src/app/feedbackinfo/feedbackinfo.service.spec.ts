import { TestBed, inject } from '@angular/core/testing';

import { FeedbackinfoService } from './feedbackinfo.service';

describe('FeedbackinfoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FeedbackinfoService]
    });
  });

  it('should be created', inject([FeedbackinfoService], (service: FeedbackinfoService) => {
    expect(service).toBeTruthy();
  }));
});
