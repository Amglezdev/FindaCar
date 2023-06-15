import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/entities/user';
import { PostService } from '../../../services/post.service';
import { CookieService } from 'ngx-cookie-service';
import { Post } from 'src/app/entities/post';
import { VehiclePictures } from 'src/app/entities/vehicle-pictures';
import { VehiclePicturesService } from 'src/app/services/vehicle-pictures.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css'],
})
export class PostComponent implements OnInit {
  user: User;
  listPost: Post[];
  listPictures: VehiclePictures[] = [];
  preFilter: Post[] = [];
  searchText: string;

  constructor(
    private ps: PostService,
    private cookieService: CookieService,
    private vps: VehiclePicturesService,
    private location: Location
  ) {}

  ngOnInit(): void {
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData;
    this.getAllPost();
  }

  filter() {
    const searchText = this.searchText ? this.searchText.toLowerCase() : '';

    if (searchText === '') {
      this.listPost = [];
      this.listPost = this.preFilter;
    } else {
      this.listPost = this.preFilter.filter(
        (post) =>
          post.vehicle.brand.toLowerCase().includes(searchText) ||
          post.vehicle.model.toLowerCase().includes(searchText) ||
          post.comment.toLowerCase().includes(searchText)
      );
    }
  }

  async getAllPost() {
    await this.ps.getAllPosts().subscribe((resp) => {
      this.preFilter = resp;
      this.filter();
    });
  }

  goBack() {
    this.location.back();
  }
}
