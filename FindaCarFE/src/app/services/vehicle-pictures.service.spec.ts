import { TestBed } from '@angular/core/testing';

import { VehiclePicturesService } from './vehicle-pictures.service';

describe('VehiclePicturesService', () => {
  let service: VehiclePicturesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VehiclePicturesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
