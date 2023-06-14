import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VehiclesRoutingModule } from './vehicles-routing.module';
import { VehiclesComponent } from './vehicles.component';
import { CreateVehicleComponent } from './create-vehicle/create-vehicle.component';
import { UpdateVehicleComponent } from './update-vehicle/update-vehicle.component';
import { DeleteVehicleComponent } from './delete-vehicle/delete-vehicle.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    VehiclesComponent,
    CreateVehicleComponent,
    UpdateVehicleComponent,
    DeleteVehicleComponent
  ],
  imports: [
    CommonModule,
    VehiclesRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class VehiclesModule { }
