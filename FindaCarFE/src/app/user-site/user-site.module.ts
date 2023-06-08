import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserSiteRoutingModule } from './user-site-routing.module';
import { UserSiteComponent } from './user-site.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    UserSiteComponent
  ],
  imports: [
    CommonModule,
    UserSiteRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class UserSiteModule { }
