import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FuelRoutingModule } from './fuel-routing.module';
import { FuelComponent } from './fuel.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AdministrationModule } from '../administration.module';


@NgModule({
  declarations: [
    FuelComponent
  ],
  imports: [
    CommonModule,
    FuelRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    AdministrationModule
  ]
})
export class FuelModule { }
