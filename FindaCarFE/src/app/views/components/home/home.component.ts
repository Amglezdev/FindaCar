import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { User } from 'src/app/entities/user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  user: User;

  constructor(private router: Router, private cookieService: CookieService) {}

  ngOnInit(): void {
    const isLogged = this.cookieService.check('userData');

    if (isLogged) {
      this.router.navigate(['/userSite']);
    }
  }
}
