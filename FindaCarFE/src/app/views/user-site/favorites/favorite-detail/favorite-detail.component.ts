import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { VehicleService } from '../../../../services/vehicle.service';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/entities/user';
import { Vehicle } from 'src/app/entities/vehicle';
import { PostService } from 'src/app/services/post.service';
import { Post } from 'src/app/entities/post';
import { FavoritesService } from 'src/app/services/favorites.service';
import { Favorites } from 'src/app/entities/favorites';
import { Location } from '@angular/common';


@Component({
  selector: 'app-favorite-detail',
  templateUrl: './favorite-detail.component.html',
  styleUrls: ['./favorite-detail.component.css'],
})
export class FavoriteDetailComponent implements OnInit {
  id: string;
  user: User;
  favorite:Favorites

  constructor(
    private cookieService: CookieService,
    private arm: ActivatedRoute,
    private location:Location,
    private fs:FavoritesService,
    private router:Router

  ) {}

  ngOnInit(): void {
    this.id = this.arm.snapshot.paramMap.get('id');
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData;
    this.getFavorite();
  }

  async getFavorite(){
    this.fs.findById(Number(this.id)).subscribe((resp) => {
      this.favorite = resp;
    })
  }


  async deleteFavorite(){
   await this.fs.deleteFromFavorites(this.favorite)
   console.log(this.favorite.id)
   this.router.navigate(['/userSite/favorites'])
  }

  goBack(){
    this.location.back()
  }
}
