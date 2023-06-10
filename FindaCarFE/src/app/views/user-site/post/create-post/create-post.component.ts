import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/services/post.service';
import { VehicleService } from 'src/app/services/vehicle.service';
import { Location } from '@angular/common';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Post } from 'src/app/entities/post';
import { Vehicle } from 'src/app/entities/vehicle';
import { CookieService } from 'ngx-cookie-service';
import { User } from 'src/app/entities/user';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent implements OnInit{

  post:Post;
  selectedVehicle:Vehicle;
  userVehicles:Vehicle[];
  user:User;
  vehicleForm:FormGroup;


  constructor(private vs:VehicleService, private pos:PostService, private location:Location, private formBuilder:FormBuilder, private cookieService:CookieService){}

  ngOnInit(): void {
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData;
    this.vs.getByUserId(this.user.id).subscribe((resp) => {
      this.userVehicles = resp;
    })
    this.vehicleForm = this.formBuilder.group({
      vehicleId: ['', Validators.required],
      comment: ['', Validators.required]
    })

  }

  onSubmit(){

    this.vs.findById(this.vehicleForm.get('id').value).subscribe((resp) =>{
      this.selectedVehicle = resp;
    })
    this.post = {
      id:0,
      comment: this.vehicleForm.get('comment').value,
      vehicle: this.selectedVehicle
    }
    this.pos.createPost(this.post);


  }

}
