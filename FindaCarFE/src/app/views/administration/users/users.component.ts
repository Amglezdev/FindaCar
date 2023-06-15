import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
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
    this.getUsers()
  }
  goBack(){
    this.location.back();
  }

  async getUsers(){
    await this.us.getAllUsers().subscribe((response) => {
      this.userList = response;
      this.userList =  this.userList.filter( x => x.rol.name != 'SuperAdministrador')
    });

  }
}
