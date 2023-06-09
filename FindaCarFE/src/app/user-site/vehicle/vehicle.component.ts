import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Fuel } from 'src/app/entities/fuel';
import { Vehicle } from 'src/app/entities/vehicle';
import { VehicleType } from 'src/app/entities/vehicle-type';
import { FuelService } from 'src/app/services/fuel.service';
import { VehicleTypesService } from 'src/app/services/vehicle-types.service';
import { VehicleService } from 'src/app/services/vehicle.service';
import { Location } from '@angular/common';
import { User } from 'src/app/entities/user';
import { CookieService } from 'ngx-cookie-service';
import { VehiclePictures } from '../../entities/vehicle-pictures';
import { VehiclePicturesService } from 'src/app/services/vehicle-pictures.service';
import * as $ from 'jquery';
import { take } from 'rxjs';

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
  picture: VehiclePictures;
  selectedType: VehicleType;
  selectedFuel: Fuel;

  constructor(
    private formBuilder: FormBuilder,
    private fsi: FuelService,
    private vts: VehicleTypesService,
    private vs: VehicleService,
    private location: Location,
    private cookieService: CookieService,
    private vp: VehiclePicturesService
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
      fuel: {
        name: '',
      },
      id: 0,
      mileage: 0,
      model: '',
      owner: null,
      power: 0,
      price: 0,
      type: {
        name: '',
      },
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
        // Crear una copia del formulario y omitir la propiedad "url"
        const vehicleData = { ...this.vehicleForm.value };
        delete vehicleData.url;

        this.vehicle = vehicleData;
        console.log(vehicleData);
        this.selectedFuel = {
          name : vehicleData.fuel
        }
        this.selectedType = {
          name : vehicleData.type
        }

        this.vehicle.type = this.selectedType;
        this.vehicle.fuel = this.selectedFuel
        console.log(this.vehicle)

        this.vs.createVehicle(this.vehicle);

      }
    } catch (error) { console.log(error)}
  }

  goBack() {
    this.location.back();
  }

}
