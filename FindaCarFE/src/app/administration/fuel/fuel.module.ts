import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FuelRoutingModule } from './fuel-routing.module';
import { FuelComponent } from './fuel.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    FuelComponent
  ],
  imports: [
    CommonModule,
    FuelRoutingModule,
    ReactiveFormsModule,
    FormsModule,
  ]
})
export class FuelModule { }
