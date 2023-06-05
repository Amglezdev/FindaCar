import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PostRoutingModule } from './post-routing.module';
import { PostComponent } from './post.component';
import { DetailPostComponent } from './detail-post/detail-post.component';
import { DetailUserComponent } from '../users/detail-user/detail-user.component';

@NgModule({
  declarations: [
    PostComponent,
    DetailPostComponent,
   
  ],
  imports: [
    CommonModule,
    PostRoutingModule
  ]
})
export class PostModule { }
