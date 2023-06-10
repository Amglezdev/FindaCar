import { Component, OnInit } from '@angular/core';
import {
  ActivatedRoute,
  ActivatedRouteSnapshot,
  Router,
} from '@angular/router';
import { MessageService } from 'src/app/services/message.service';
import { User } from 'src/app/entities/user';
import { Message } from 'src/app/entities/message';
import { CookieService } from 'ngx-cookie-service';
import { UserService } from 'src/app/services/user.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-detail-chat',
  templateUrl: './chat-detail.component.html',
  styleUrls: ['./chat-detail.component.css'],
})
export class ChatDetailComponent implements OnInit {
  user: User;
  newMessage: Message;
  listMessage: Message[];
  reciever: User;
  messageForm: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private messageService: MessageService,
    private cookieService: CookieService,
    private us: UserService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.messageForm = this.formBuilder.group({
      content: ['', Validators.required],
    });
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData;
    console.log(this.user);
    const recieverId = this.route.snapshot.paramMap.get('id');

    this.us.getUserById(Number(recieverId)).subscribe((resp) => {
      this.reciever = resp;
      console.log(resp);
      console.log(this.reciever);
    });

    this.getMessages();
  }

  getMessages() {
    this.messageService
      .findMessages(this.user.id, this.reciever.id)
      .subscribe((resp) => {
        this.listMessage = resp;
      });
  }

  sendMessage(): void {
    this.newMessage = {
      id: 0,
      content: this.messageForm.get('content').value,
      sender: this.user,
      reciever: this.reciever,
    };
    console.log(this.newMessage);
    this.messageService.sendMessage(this.newMessage);
  }

  logOut() {
    this.cookieService.deleteAll();
    this.router.navigate(['/login']);
  }
}
