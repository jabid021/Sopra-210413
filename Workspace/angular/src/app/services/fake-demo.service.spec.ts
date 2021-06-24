import { TestBed } from '@angular/core/testing';

import { FakeDemoService } from './fake-demo.service';

describe('FakeDemoService', () => {
  let service: FakeDemoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FakeDemoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
