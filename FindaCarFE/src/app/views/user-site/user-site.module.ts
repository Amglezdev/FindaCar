import { NgModule } from '@angular/core';
import { CommonModule, Location } from '@angular/common';

import { UserSiteRoutingModule } from './user-site-routing.module';
import { UserSiteComponent } from './user-site.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { VehiclePicturesComponent } from './vehicle-pictures/vehicle-pictures.component';


@NgModule({
  declarations: [
    UserSiteComponent,
  ],
  imports: [
    CommonModule,
    UserSiteRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule
  ],
  providers:[Location, RouterModule]
})
export class UserSiteModule { }
