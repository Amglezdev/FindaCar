import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';
import { User } from 'src/app/entities/user';
import { Vehicle } from 'src/app/entities/vehicle';
import { VehiclePictures } from 'src/app/entities/vehicle-pictures';
import { VehiclePicturesService } from 'src/app/services/vehicle-pictures.service';
import { VehicleService } from 'src/app/services/vehicle.service';
import { Location } from '@angular/common';
import { NavbarComponent } from '../navbar/navbar.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vehicle-pictures',
  templateUrl: './vehicle-pictures.component.html',
  styleUrls: ['./vehicle-pictures.component.css'],
})
export class VehiclePicturesComponent implements OnInit {
  user: User;
  listVehicle: Vehicle[];
  picture: VehiclePictures;
  imageForm: FormGroup;
  selectedVehicle: Vehicle;

  constructor(
    private formBuilder: FormBuilder,
    private vs: VehicleService,
    private location: Location,
    private cookieService: CookieService,
    private vp: VehiclePicturesService,
    private router:Router
  ) {}

  ngOnInit() {
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData
    this.vs.getByUserId(this.user.id).subscribe((resp) => {
      this.listVehicle = resp;
    });
    this.imageForm = this.formBuilder.group({
      imageUrl: ['', Validators.required],
      selectedVehicle: ['', Validators.required]
    });
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
  }
}
async submitForm() {
  this.selectedVehicle = this.imageForm.get('selectedVehicle').value
  this.picture = {
    id: 0,
    image: this.imageForm.get('imageUrl').value,
    vehicle: this.selectedVehicle,
  };
  await this.vp.addPicture(this.picture)
    this.router.navigate(['/userSite/post'])
}
goBack(){
  this.location.back()
}
}
