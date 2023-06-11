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

  constructor(
    private ps: PostService,
    private cookieService: CookieService,
    private vps: VehiclePicturesService,
    private location:Location
  ) {}

  ngOnInit(): void {
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData;
    this.ps.getAllPosts().subscribe((resp) => {
      this.preFilter = resp;
    });
  }

  filter(string:any){

    console.log(string.target.value)

    this.listPost = this.preFilter.filter(x => x.comment.includes(string.target.value) || x.vehicle.model.includes(string.target.value) || x.vehicle.brand.includes(string.target.value))

  }

  goBack(){
    this.location.back()
  }
}
