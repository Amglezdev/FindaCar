import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { Fuel } from 'src/app/entities/fuel';
import { User } from 'src/app/entities/user';
import { Vehicle } from 'src/app/entities/vehicle';
import { VehicleType } from 'src/app/entities/vehicle-type';
import { FuelService } from 'src/app/services/fuel.service';
import { VehicleTypesService } from 'src/app/services/vehicle-types.service';
import { VehicleService } from 'src/app/services/vehicle.service';

@Component({
  selector: 'app-update-vehicle',
  templateUrl: './update-vehicle.component.html',
  styleUrls: ['./update-vehicle.component.css'],
})
export class UpdateVehicleComponent implements OnInit {
  user: User;
  vehicle: Vehicle;
  listFuel: Fuel[];
  listType: VehicleType[];

  constructor(
    private cookieService: CookieService,
    private vs: VehicleService,
    private arm: ActivatedRoute,
    private location: Location,
    private fs:FuelService,
    private vts:VehicleTypesService,
    private router:Router
  ) {}

  ngOnInit(): void {
    const userId = this.arm.snapshot.paramMap.get('id');
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData;
    this.getVehicle(Number(userId));
    this.getFuels();
    this.getTypes();
  }

  async getVehicle(id: number) {
    await this.vs.findById(id).subscribe((resp) => {
      this.vehicle = resp;
    });
  }

  goBack() {
    this.location.back();
  }

  updateVehicle() {
    this.vs.updateVehicle(this.vehicle);
    this.router.navigate(['/userSite/vehicles'])
  }

  async getFuels(){
    await this.fs.getAllTypes().subscribe((resp) =>{
      this.listFuel = resp;
    })
  }
  async getTypes(){
    await this.vts.getAllTypes().subscribe((resp) =>{
      this.listType = resp;
    })
  }

}
