import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';
import { Fuel } from 'src/app/entities/fuel';
import { User } from 'src/app/entities/user';
import { Vehicle } from 'src/app/entities/vehicle';
import { VehiclePictures } from 'src/app/entities/vehicle-pictures';
import { VehicleType } from 'src/app/entities/vehicle-type';
import { FuelService } from 'src/app/services/fuel.service';
import { VehiclePicturesService } from 'src/app/services/vehicle-pictures.service';
import { VehicleTypesService } from 'src/app/services/vehicle-types.service';
import { VehicleService } from 'src/app/services/vehicle.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-create-vehicle',
  templateUrl: './create-vehicle.component.html',
  styleUrls: ['./create-vehicle.component.css'],
})
export class CreateVehicleComponent implements OnInit {
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
    private vp: VehiclePicturesService,
    private router: Router
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

  async createVehicle() {
    try {
      if (this.vehicleForm.valid) {
        // Crear una copia del formulario y omitir la propiedad "url"
        const vehicleData = { ...this.vehicleForm.value };

        this.vehicle = vehicleData;
        this.selectedFuel = {
          name: vehicleData.fuel,
        };
        this.selectedType = {
          name: vehicleData.type,
        };

        this.vehicle.type = this.selectedType;
        this.vehicle.fuel = this.selectedFuel;

        await this.vs.createVehicle(this.vehicle);
        this.router.navigate(['userSite/vehicles']);
      }
    } catch (error) {
      console.log(error);
    }
  }

  goBack() {
    this.location.back();
  }
}
