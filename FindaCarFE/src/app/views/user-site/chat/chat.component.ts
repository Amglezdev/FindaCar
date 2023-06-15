import { Component, OnInit } from '@angular/core';
import { Conversation } from '../../../entities/conversation';
import { ConversationService } from 'src/app/services/conversation.service';
import { User } from '../../../entities/user';
import { UserService } from 'src/app/services/user.service';
import { CookieService } from 'ngx-cookie-service';
import { UsersModule } from '../../administration/users/users.module';
import { Router } from '@angular/router';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css'],
})
export class ChatComponent implements OnInit {
  user: User;
  selectedUser: User;
  conversationList: Conversation[];
  conversation: Conversation;
  searchText:string;
  userList:User[];
  preFilter:User[];

  constructor(
    private cs: ConversationService,
    private us: UserService,
    private cookieService: CookieService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData;
    this.getAllConversations();
  }

  async getAllConversations() {
    await this.cs.findByUser(this.user).subscribe((resp) => {
      this.conversationList = resp;
    });
  }

  async createConversation() {
    this.conversation = {
      id: 0,
      sender: this.user,
      reciever: this.selectedUser,
    };
    if ((await this.cs.createConversation(this.conversation)) === true) {
      await this.cs
        .findBySenderAndReciever(this.user, this.selectedUser)
        .subscribe((resp) => { this.router.navigate(['/chatWindow/' + resp.id])});
    }
  }

  filter() {
    const searchText = this.searchText ? this.searchText.toLowerCase() : '';

    if (searchText === '') {
      this.userList = [];
      this.userList = this.preFilter;
    } else {
      this.userList = this.preFilter.filter(
        (user) =>
          user.name.toLowerCase().includes(searchText) ||
          user.surname.toLowerCase().includes(searchText) ||
          user.mail.toLowerCase().includes(searchText)
      );
    }
  }

  openChat(id:Number){
    this.router.navigate(['/chatWindow/' + id])
  }

}
