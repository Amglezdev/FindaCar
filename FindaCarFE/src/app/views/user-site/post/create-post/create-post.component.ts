import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/services/post.service';
import { VehicleService } from 'src/app/services/vehicle.service';
import { Location } from '@angular/common';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Post } from 'src/app/entities/post';
import { Vehicle } from 'src/app/entities/vehicle';
import { CookieService } from 'ngx-cookie-service';
import { User } from 'src/app/entities/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css'],
})
export class CreatePostComponent implements OnInit {
  post: Post;
  selectedVehicle: Vehicle;
  userVehicles: Vehicle[];
  user: User;
  vehicleForm: FormGroup;

  constructor(
    private vs: VehicleService,
    private pos: PostService,
    private location: Location,
    private formBuilder: FormBuilder,
    private cookieService: CookieService,
    private router:Router
  ) {}

  ngOnInit(): void {
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData;
    this.vs.getByUserId(this.user.id).subscribe((resp) => {
      this.userVehicles = resp;
    });
    this.vehicleForm = this.formBuilder.group({
      vehicle: ['', Validators.required],
      comment: ['', Validators.required],
    });
  }

  async onSubmit() {
    this.selectedVehicle = {
      age: null,
      brand: '',
      fuel: {
        name: '',
      },
      id: 0,
      mileage: 0,
      model: '',
      owner: null,
      power: 0,
      price: 0,
      type: {
        name: '',
      },
    };

    const id = this.vehicleForm.get('vehicle').value;
    console.log(Number(id));

    this.post = {
      id: 0,
      comment: this.vehicleForm.get('comment').value,
      vehicle: this.vehicleForm.get('vehicle').value,
    };
    await this.pos.createPost(this.post).then(this.router.navigate['/']);

  }

  goBack(){
    this.location.back()
  }
}
