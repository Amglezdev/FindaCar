import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PostRoutingModule } from './post-routing.module';
import { PostComponent } from './post.component';
import { AdministrationModule } from '../administration.module';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

@NgModule({
  declarations: [PostComponent],
  imports: [
    CommonModule,
    PostRoutingModule,
    AdministrationModule,
    ReactiveFormsModule,
    FormsModule,
    AdministrationModule
  ],
})
export class PostModule {}
