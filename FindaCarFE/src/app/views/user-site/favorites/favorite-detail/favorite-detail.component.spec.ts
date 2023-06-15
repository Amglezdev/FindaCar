import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FavoriteDetailComponent } from './favorite-detail.component';

describe('FavoriteDetailComponent', () => {
  let component: FavoriteDetailComponent;
  let fixture: ComponentFixture<FavoriteDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FavoriteDetailComponent]
    });
    fixture = TestBed.createComponent(FavoriteDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
