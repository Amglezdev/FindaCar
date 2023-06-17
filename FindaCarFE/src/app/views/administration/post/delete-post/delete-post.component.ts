import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { Favorites } from 'src/app/entities/favorites';
import { Post } from 'src/app/entities/post';
import { User } from 'src/app/entities/user';
import { Vehicle } from 'src/app/entities/vehicle';
import { VehiclePictures } from 'src/app/entities/vehicle-pictures';
import { FavoritesService } from 'src/app/services/favorites.service';
import { PostService } from 'src/app/services/post.service';
import { VehiclePicturesService } from 'src/app/services/vehicle-pictures.service';
import { VehicleService } from 'src/app/services/vehicle.service';

@Component({
  selector: 'app-delete-post',
  templateUrl: './delete-post.component.html',
  styleUrls: ['./delete-post.component.css'],
})
export class DeletePostComponent implements OnInit {
  id: string;
  vehicle: Vehicle;
  listPictures: VehiclePictures[];
  post: Post;
  favorites: Favorites;
  user: User;

  constructor(
    private vs: VehicleService,
    private vp: VehiclePicturesService,
    private fav: FavoritesService,
    private cookieService: CookieService,
    private arm: ActivatedRoute,
    private pos: PostService,
    private router: Router,
    private location: Location
  ) {}

  ngOnInit(): void {
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData;
    this.id = this.arm.snapshot.paramMap.get('id');
    this.pos.findById(Number(this.id)).subscribe((resp) => {
      this.post = resp;
    });
    this.vs.findById(Number(this.id)).subscribe((resp) => {
      this.vehicle = resp;
    });
  }

  deletePost() {
    this.pos.deletePost(this.post);
    this.router.navigate(['/userSite/post']);
  }
  goBack() {
    this.location.back();
  }
}
