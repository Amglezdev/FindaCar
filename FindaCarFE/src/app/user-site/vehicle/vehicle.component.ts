import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Fuel } from 'src/app/entities/fuel';
import { Vehicle } from 'src/app/entities/vehicle';
import { VehicleType } from 'src/app/entities/vehicle-type';
import { FuelService } from 'src/app/services/fuel.service';
import { VehicleTypesService } from 'src/app/services/vehicle-types.service';
import { VehicleService } from 'src/app/services/vehicle.service';
import { Location } from '@angular/common';
import { async } from 'rxjs';
import { User } from 'src/app/entities/user';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css'],
})
export class VehicleComponent implements OnInit {
  vehicleForm: FormGroup;
  listType: VehicleType[];
  listFuel: Fuel[];
  vehicle: Vehicle;
  user: User;
  selectedType: VehicleType;
  selectedFuel: Fuel;

  constructor(
    private formBuilder: FormBuilder,
    private fsi: FuelService,
    private vts: VehicleTypesService,
    private vs: VehicleService,
    private location: Location,
    private cookieService: CookieService
  ) {}

  ngOnInit() {
    this.selectedFuel = {
      name: '',
    };
    this.selectedType = {
      name: '',
    };
    this.vehicle = {
      age: null,
      brand: '',
      fuel: this.selectedFuel,
      id: 0,
      mileage: 0,
      model: '',
      owner: null,
      power: 0,
      price: 0,
      type: this.selectedType,
    };
    this.getFuelTypes();
    this.getVehicleTypes();

    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData;

    this.vehicleForm = this.formBuilder.group({
      id: [0],
      brand: ['', Validators.required],
      model: ['', Validators.required],
      power: ['', Validators.required],
      mileage: ['', Validators.required],
      type: ['', Validators.required],
      fuel: ['', Validators.required],
      age: ['', Validators.required],
      owner: [this.user, Validators.required],
      price: ['', Validators.required],
    });
  }

  async getVehicleTypes() {
    await this.vts.getAllTypes().subscribe((resp) => {
      this.listType = resp;
    });
  }

  async getFuelTypes() {
    await this.fsi.getAllTypes().subscribe((resp) => {
      this.listFuel = resp;
    });
  }

  createVehicle() {
    try {
      if (this.vehicleForm.valid) {
        this.vehicle = this.vehicleForm.value;
        if (this.vs.createVehicle(this.vehicle)) {
          console.log('Creado');
        } else {
          console.log('No se ha creado');
        }
      }
    } catch (error) {}
  }

  goBack() {
    this.location.back();
  }
}
