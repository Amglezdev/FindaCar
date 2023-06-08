import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { AdminSiteGuard } from './admin-site.guard';

describe('adminGuardGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) =>
    TestBed.inject(AdminSiteGuard).canActivate(...guardParameters);

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
