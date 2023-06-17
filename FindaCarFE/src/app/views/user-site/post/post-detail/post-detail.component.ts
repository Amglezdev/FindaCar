import { Location } from '@angular/common';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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
import Swiper, { Navigation, Pagination } from 'swiper';
@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css'],
})

export class PostDetailComponent implements OnInit, AfterViewInit {
  @ViewChild('swiperContainer') swiperContainer: any;
  id: string;
  listPictures: VehiclePictures[];
  post: Post;
  favorites: Favorites;
  user: User;
  swiper:Swiper

  constructor(
    private location: Location,
    private vs: VehicleService,
    private vp: VehiclePicturesService,
    private fav: FavoritesService,
    private cookieService: CookieService,
    private arm: ActivatedRoute,
    private pos: PostService
  ) {}

  ngAfterViewInit(): void {
    this.swiper = new Swiper('.vehicle-slideshow', {
      // Configuración del carrusel de imágenes
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev'
      },
      pagination: {
        el: '.swiper-pagination',
        clickable: true
      }
    });
  }

  private initSwiper(): void {
    this.swiper = new Swiper(this.swiperContainer.nativeElement, {
      slidesPerView: 1,
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
      pagination: {
        el: '.swiper-pagination',
      },
    });
  }

  ngOnInit(): void {
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData;
    this.id = this.arm.snapshot.paramMap.get('id');
    this.getPost();
  }
  goBack() {
    this.location.back();
  }

  async getPost() {
    await this.pos.findById(Number(this.id)).subscribe((resp) => {
      this.post = resp;
       this.getVehiclePicture(this.post)
    });
  }
  async getVehiclePicture(post:Post) {
    await this.vp.getByVehicleId(post.vehicle.id).subscribe((resp) => {
      this.listPictures = resp;
    });
  }
  async saveFavorite(){
    this.favorites = {
      id:0,
      user: this.user,
      vehicle: this.post.vehicle,
    }
    console.log(this.favorites)
    await this.fav.addFavorites(this.favorites);
  }
}
