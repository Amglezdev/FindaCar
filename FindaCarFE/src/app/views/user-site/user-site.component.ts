import { Component, OnInit } from '@angular/core';

import { User } from 'src/app/entities/user';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-user-site',
  templateUrl: './user-site.component.html',
  styleUrls: ['./user-site.component.css'],
})
export class UserSiteComponent implements OnInit {

  user:User;
  constructor(private router: Router, private cookieService: CookieService) {}

  ngOnInit(): void {
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData;
  }



  logOut() {
    this.cookieService.deleteAll();
    this.router.navigate(['/login']);
  }
}
