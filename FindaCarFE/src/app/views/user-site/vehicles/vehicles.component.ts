import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { User } from 'src/app/entities/user';
import { Vehicle } from 'src/app/entities/vehicle';
import { VehicleService } from 'src/app/services/vehicle.service';

@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnInit{

  vehicleList:Vehicle[];
  user:User;

  constructor(private cookieService:CookieService, private vs:VehicleService, private location:Location){}


  ngOnInit(): void {
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData;
    this.vs.getByUserId(this.user.id).subscribe((resp) =>{
      this.vehicleList = resp;
    })
  }

}
