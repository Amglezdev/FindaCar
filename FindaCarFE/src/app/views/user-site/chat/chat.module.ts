import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ChatRoutingModule } from './chat-routing.module';
import { ChatComponent } from './chat.component';
import { ChatWindowComponent } from './chat-window/chat-window.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserSiteModule } from '../user-site.module';


@NgModule({
  declarations: [
    ChatComponent,
    ChatWindowComponent
  ],
  imports: [
    CommonModule,
    ChatRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    UserSiteModule
  ]
})
export class ChatModule { }
