import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserSiteRoutingModule } from './user-site-routing.module';
import { UserSiteComponent } from './user-site.component';


@NgModule({
  declarations: [
    UserSiteComponent
  ],
  imports: [
    CommonModule,
    UserSiteRoutingModule
  ]
})
export class UserSiteModule { }
