import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/entities/user';
import { PostService } from '../../../services/post.service';
import { CookieService } from 'ngx-cookie-service';
import { Post } from 'src/app/entities/post';
import { VehiclePictures } from 'src/app/entities/vehicle-pictures';
import { VehiclePicturesService } from 'src/app/services/vehicle-pictures.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit{

  user:User;
  listPost:Post[];
  listPictures:VehiclePictures[];

  constructor(private ps:PostService, private cookieService:CookieService, private vps:VehiclePicturesService){}


  ngOnInit(): void {
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData;
    this.ps.getAllTypes().subscribe((resp) => {
      this.listPost = resp;
    })
  }

  getVehicleImageUrl(id:number){
    this.vps.getByVehicleId(id).subscribe((resp) => {
      this.listPictures = resp;
      return this.listPictures[0].image;
    })
  }



}
