import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehiclePicturesComponent } from './vehicle-pictures.component';

describe('VehiclePicturesComponent', () => {
  let component: VehiclePicturesComponent;
  let fixture: ComponentFixture<VehiclePicturesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VehiclePicturesComponent]
    });
    fixture = TestBed.createComponent(VehiclePicturesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
