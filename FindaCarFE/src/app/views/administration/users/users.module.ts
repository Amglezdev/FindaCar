import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsersRoutingModule } from './users-routing.module';
import { UsersComponent } from './users.component';
import { UserService } from 'src/app/services/user.service';
import { EditUserComponent } from './edit-user/edit-user.component';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap'
import { DetailUserComponent } from './detail-user/detail-user.component';
import { ConfirmDeleteComponent } from './confirm-delete/confirm-delete.component';
import { AdministrationModule } from '../administration.module';


@NgModule({
  declarations: [
    UsersComponent,
    EditUserComponent,
    DetailUserComponent,
    ConfirmDeleteComponent,
  ],
  imports: [
    CommonModule,
    UsersRoutingModule,
    FormsModule,
    NgbModule,
    AdministrationModule
  ],
  providers:[UserService]
})
export class UsersModule { }
