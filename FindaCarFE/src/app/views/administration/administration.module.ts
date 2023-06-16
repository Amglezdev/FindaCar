import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdministrationRoutingModule } from './administration-routing.module';
import { AdministrationComponent } from './administration.component';
import { RouterModule } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [
    AdministrationComponent,
    NavbarComponent,
  ],
  imports: [CommonModule, AdministrationRoutingModule, RouterModule],
  providers:[UserService],
  exports:[NavbarComponent]
})
export class AdministrationModule {}
