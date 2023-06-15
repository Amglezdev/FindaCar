import { Component, OnInit } from '@angular/core';
import { Vehicle } from '../../../../entities/vehicle';
import { CookieService } from 'ngx-cookie-service';
import { VehicleService } from '../../../../services/vehicle.service';
import { Location } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { VehiclesModule } from '../vehicles.module';
import { User } from 'src/app/entities/user';

@Component({
  selector: 'app-delete-vehicle',
  templateUrl: './delete-vehicle.component.html',
  styleUrls: ['./delete-vehicle.component.css'],
})
export class DeleteVehicleComponent implements OnInit {
  vehicle: Vehicle;
  user: User;
  id:string;

  constructor(
    private cookieService: CookieService,
    private vs: VehicleService,
    private location: Location,
    private arm: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.id = this.arm.snapshot.paramMap.get('id');
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData;
    this.getVehicleId();
  }

  goBack() {
    this.location.back();
  }

  async deleteVehicle() {
    await this.vs.deleteVehicle(this.vehicle);
    this.router.navigate(['/vehicles'])
  }
  async getVehicleId(){
    await this.vs.findById(Number(this.id)).subscribe((resp) =>{
      this.vehicle = resp;
    })
  }
}
