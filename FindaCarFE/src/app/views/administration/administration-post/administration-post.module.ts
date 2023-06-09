import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdministrationPostRoutingModule } from './administration-post-routing.module';
import { AdministrationPostComponent } from './administration-post.component';


@NgModule({
  declarations: [
    AdministrationPostComponent
  ],
  imports: [
    CommonModule,
    AdministrationPostRoutingModule
  ]
})
export class AdministrationPostModule { }
