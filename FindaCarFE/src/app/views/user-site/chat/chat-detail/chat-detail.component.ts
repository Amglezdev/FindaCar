import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot, Router } from '@angular/router';
import { MessageService } from 'src/app/services/message.service';
import { User } from 'src/app/entities/user';
import { Message } from 'src/app/entities/message';
import { CookieService } from 'ngx-cookie-service';
import { UserService } from 'src/app/services/user.service';

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

  constructor(
    private route: ActivatedRoute,
    private messageService: MessageService,
    private cookieService: CookieService,
    private us:UserService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData;
    const recieverId = this.route.snapshot.paramMap.get('id');
    this.us.getUserById(Number(recieverId)).subscribe((resp) =>{
      this.reciever = resp;
    })

  }

  sendMessage(): void {


  }

  logOut() {
    this.cookieService.deleteAll();
    this.router.navigate(['/login']);
  }
}
