import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { user } from 'src/environments/environments';
import { Location } from '@angular/common';

@Component({
  selector: 'app-administration',
  templateUrl: './administration.component.html',
  styleUrls: ['./administration.component.css']
})
export class AdministrationComponent implements OnInit{
  ngOnInit(): void {

  }
  constructor(private router:Router, private location:Location){}

  logOut(){
    user.rol.name = '';
    window.location.reload();
    this.router.navigate(['/login'])

  }

}
