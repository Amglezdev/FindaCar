import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { userSiteGuard } from './user-site.guard';

describe('userSiteGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => userSiteGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
