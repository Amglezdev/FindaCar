import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';
import { User } from 'src/app/entities/user';
import { Vehicle } from 'src/app/entities/vehicle';
import { VehiclePictures } from 'src/app/entities/vehicle-pictures';
import { VehiclePicturesService } from 'src/app/services/vehicle-pictures.service';
import { VehicleService } from 'src/app/services/vehicle.service';

@Component({
  selector: 'app-vehicle-pictures',
  templateUrl: './vehicle-pictures.component.html',
  styleUrls: ['./vehicle-pictures.component.css']
})
export class VehiclePicturesComponent implements OnInit{

  constructor(
    private formBuilder: FormBuilder,
    private vs: VehicleService,
    private location: Location,
    private cookieService: CookieService,
    private vp: VehiclePicturesService
  ) {}

  user:User;
  listVehicle:Vehicle[];
  picture:VehiclePictures;

  ngOnInit(): void {
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData;
  }

}
