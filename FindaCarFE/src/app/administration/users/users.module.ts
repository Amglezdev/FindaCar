import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsersRoutingModule } from './users-routing.module';
import { UsersComponent } from './users.component';
import { UserService } from 'src/app/services/user.service';
import { EditUserComponent } from './edit-user/edit-user.component';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap'
import { DetailUserComponent } from './detail-user/detail-user.component';


@NgModule({
  declarations: [
    UsersComponent,
    EditUserComponent,
    DetailUserComponent,
  ],
  imports: [
    CommonModule,
    UsersRoutingModule,
    FormsModule,
    NgbModule
  ],
  providers:[UserService]
})
export class UsersModule { }
