import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { Location } from '@angular/common';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-administration',
  templateUrl: './administration.component.html',
  styleUrls: ['./administration.component.css']
})
export class AdministrationComponent implements OnInit{
  ngOnInit(): void {

  }
  constructor(private router:Router, private location:Location, private cookieService:CookieService){}

  logOut() {
    this.cookieService.deleteAll();
    this.router.navigate(['/login']);
  }

}
