import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { Favorites } from 'src/app/entities/favorites';
import { User } from 'src/app/entities/user';
import { FavoritesService } from 'src/app/services/favorites.service';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.css']
})
export class FavoritesComponent implements OnInit{

  favoriteList:Favorites[];
  user:User;

  constructor(private fs:FavoritesService, private cookieService:CookieService){}

  ngOnInit(): void {
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData;
    this.getFavoritesByUser();
  }

  async getFavoritesByUser(){
    await this.fs.getUserById(this.user.id).subscribe((resp) =>{
      this.favoriteList = resp;
      console.log(resp)
    })
  }

}
