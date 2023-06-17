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

  conversation:Conversation = {
    id:0,
    reciever:null,
    sender:null,
  };
  message:Message;
  listMessage:Message[];
  user:User;
  converId:string;
  newMessageContent:string = '';


  constructor(private cookieService:CookieService, private us:UserService, private ms:MessageService, private cs:ConversationService, private arm:ActivatedRoute){}

  ngOnInit(): void {
    this.converId = this.arm.snapshot.paramMap.get('id');
    this.findByConversationId(Number(this.converId))
    this.findConversation(Number(this.converId))
  }

  async sendMessage(){
    this.message = {
      content : this.newMessageContent,
      conversation : this.conversation,
      id:0,
    }
    await this.ms.sendMessage(this.message)
    this.findByConversationId(Number(this.converId))
    this.newMessageContent = '';
  }

  async findByConversationId(id:Number){
    await this.ms.findByConversationId(Number(this.converId)).subscribe((resp) => {
      this.listMessage = resp;
    })
  }

  async findConversation(id:number){
    await this.cs.findById(id).subscribe((resp) => {
      this.conversation = resp;
    });
  }

}
