import { NgModule } from '@angular/core';
import { CommonModule, Location } from '@angular/common';

import { UserSiteRoutingModule } from './user-site-routing.module';
import { UserSiteComponent } from './user-site.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { VehiclePicturesComponent } from './vehicle-pictures/vehicle-pictures.component';
import { NavbarComponent } from './navbar/navbar.component';
import { bootstrapApplication } from '@angular/platform-browser';


@NgModule({
  declarations: [UserSiteComponent, NavbarComponent],
  imports: [
    CommonModule,
    UserSiteRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
  ],
  providers: [Location, RouterModule],
  exports: [NavbarComponent],
})
export class UserSiteModule {}
