import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PostRoutingModule } from './post-routing.module';
import { PostComponent } from './post.component';
import { PostDetailComponent } from './post-detail/post-detail.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DeletePostComponent } from './delete-post/delete-post.component';
import { UserSiteModule } from '../user-site.module';
import { NavbarComponent } from '../navbar/navbar.component';



@NgModule({
  declarations: [
    PostComponent,
    PostDetailComponent,
    CreatePostComponent,
    DeletePostComponent,
  ],
  imports: [
    CommonModule,
    PostRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    UserSiteModule,
  ]
})
export class PostModule { }
