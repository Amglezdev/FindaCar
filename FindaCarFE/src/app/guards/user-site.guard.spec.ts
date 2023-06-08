import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { UserSiteGuard } from './user-site.guard';

describe('UserSiteGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) =>
    TestBed.inject(UserSiteGuard).canActivate(...guardParameters);

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
