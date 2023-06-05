import { Component, OnInit } from '@angular/core';
import { user } from '../../environments/environments';
import { User } from '../entities/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-site',
  templateUrl: './user-site.component.html',
  styleUrls: ['./user-site.component.css']
})
export class UserSiteComponent implements OnInit{

  constructor(private router:Router){}
  ngOnInit(): void {

  }



  user:User = user;

  logOut(){
    user.rol.name = '';
    window.location.reload();
    this.router.navigate(['/login'])

  }
}
