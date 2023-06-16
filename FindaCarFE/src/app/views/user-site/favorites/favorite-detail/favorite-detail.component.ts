import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { VehicleService } from '../../../../services/vehicle.service';
import { ActivatedRoute } from '@angular/router';
import { User } from 'src/app/entities/user';
import { Vehicle } from 'src/app/entities/vehicle';

@Component({
  selector: 'app-favorite-detail',
  templateUrl: './favorite-detail.component.html',
  styleUrls: ['./favorite-detail.component.css'],
})
export class FavoriteDetailComponent implements OnInit {
  id: string;
  user: User;
  vehicle: Vehicle;

  constructor(
    private cookieService: CookieService,
    private vs: VehicleService,
    private arm: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.id = this.arm.snapshot.paramMap.get('id');
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData;
  }

  async getVehicle() {
    this.vs.findById(Number(this.id)).subscribe((resp) => {
      this.vehicle = resp;
    });
  }
}
