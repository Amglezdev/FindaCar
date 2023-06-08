import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Fuel } from 'src/app/entities/fuel';
import { Vehicle } from 'src/app/entities/vehicle';
import { VehicleType } from 'src/app/entities/vehicle-type';
import { FuelService } from 'src/app/services/fuel.service';
import { VehicleTypesService } from 'src/app/services/vehicle-types.service';
import { VehicleService } from 'src/app/services/vehicle.service';
import { user } from 'src/environments/environments';
import { Location } from '@angular/common';

@Component({
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css'],
})
export class VehicleComponent implements OnInit {

  vehicleForm: FormGroup;
  listType: VehicleType[];
  listFuel: Fuel[];
  vehicle:Vehicle;

  constructor(
    private formBuilder: FormBuilder,
    private fsi: FuelService,
    private vts: VehicleTypesService,
    private vs:VehicleService,
    private location:Location
  ) {}

  ngOnInit() {
    this.vts.getAllTypes().subscribe((resp) => {
      this.listType = resp;
    });
    this.fsi.getAllTypes().subscribe((resp) => {
      this.listFuel = resp;
    });
    console.log(user);
    this.vehicleForm = this.formBuilder.group({
      id: [0],
      brand: ['', Validators.required],
      model: ['', Validators.required],
      power: ['', Validators.required],
      mileage: ['', Validators.required],
      type: ['', Validators.required],
      age: ['', Validators.required],
      owner: [user, Validators.required],
      price: ['', Validators.required],
    });

  }

  createVehicle() {
    try {
      if (this.vehicleForm.valid) {
        this.vehicle = this.vehicleForm.value;
        if(this.vs.createVehicle(this.vehicle)){
          console.log('Creado')

        }else{
          console.log('No se ha creado')
        }
      }
    } catch (error) {}
  }

  goBack(){
    this.location.back();
  }

}
