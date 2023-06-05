import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from 'src/app/entities/user';
import { Location } from '@angular/common';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css'],
})
export class UsersComponent implements OnInit {
  userList: User[];

  constructor(private us: UserService, private location:Location) {}

  ngOnInit() {
    this.us.getAllUsers().subscribe((response) => {
      this.userList = response;
    });
  }
  goBack(){
    this.location.back();
  }
}
