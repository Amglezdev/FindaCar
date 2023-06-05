import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdministrationRoutingModule } from './administration-routing.module';
import { AdministrationComponent } from './administration.component';
import { RouterModule } from '@angular/router';
import { UserService } from '../services/user.service';

@NgModule({
  declarations: [
    AdministrationComponent,
  ],
  imports: [CommonModule, AdministrationRoutingModule, RouterModule],
  providers:[UserService]
})
export class AdministrationModule {}
