import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VehicleTypesRoutingModule } from './vehicle-types-routing.module';
import { VehicleTypesComponent } from './vehicle-types.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    VehicleTypesComponent
  ],
  imports: [
    CommonModule,
    VehicleTypesRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class VehicleTypesModule { }
