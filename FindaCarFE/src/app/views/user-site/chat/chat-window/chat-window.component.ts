import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { ConversationService } from 'src/app/services/conversation.service';
import { MessageService } from 'src/app/services/message.service';
import { UserService } from 'src/app/services/user.service';
import { Conversation } from '../../../../entities/conversation';
import { Message } from 'src/app/entities/message';
import { User } from 'src/app/entities/user';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-chat-window',
  templateUrl: './chat-window.component.html',
  styleUrls: ['./chat-window.component.css']
})
export class ChatWindowComponent implements OnInit{

  conversation:Conversation;
  message:Message;
  listMessage:Message[];
  user:User;
  converId:string;
  newMessageContent:string


  constructor(private cookieService:CookieService, private us:UserService, private ms:MessageService, private cs:ConversationService, private arm:ActivatedRoute){}

  ngOnInit(): void {
    this.converId = this.arm.snapshot.paramMap.get('id');
    this.findConversation(this.converId)
    this.findByConversationId(this.conversation)
  }

  async sendMessage(){
    await this.ms.sendMessage(this.message)
    await this.ms.findByConversationId(this.conversation)

  }

  async findByConversationId(conver:Conversation){
    await this.ms.findByConversationId(conver).subscribe((resp) => {
      this.listMessage = resp;
    })
  }

  async findConversation(id:string){
    await this.cs.findById(Number(id)).subscribe((resp) =>{
      this.conversation = resp;
    })
  }
}
