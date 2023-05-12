import { TestBed } from '@angular/core/testing';

import { Http403Guard } from './http403.guard';

describe('Http403Guard', () => {
  let guard: Http403Guard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(Http403Guard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
