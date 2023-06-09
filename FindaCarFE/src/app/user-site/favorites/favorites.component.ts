import { Component, OnInit } from '@angular/core';
import { Favorites } from 'src/app/entities/favorites';
import { FavoritesService } from 'src/app/services/favorites.service';
import { CookieService } from 'ngx-cookie-service';
import { User } from 'src/app/entities/user';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.css']
})

export class FavoritesComponent implements OnInit{

  listFavorites:Favorites[];

  constructor(private fs:FavoritesService, private cookieService:CookieService){}

  user:User;

  ngOnInit(): void {

  }

}
