import { Component, OnInit } from '@angular/core';
import { VehicleTypesService } from 'src/app/services/vehicle-types.service';
import { Location } from '@angular/common';
import { VehicleType } from 'src/app/entities/vehicle-type';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-vehicle-types',
  templateUrl: './vehicle-types.component.html',
  styleUrls: ['./vehicle-types.component.css'],
})
export class VehicleTypesComponent implements OnInit {
  listType: VehicleType[];
  type: VehicleType;
  formGroup: FormGroup;

  constructor(
    private vts: VehicleTypesService,
    private location: Location,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.vts.getAllTypes().subscribe((resp) => {
      this.listType = resp;
    })
    this.formGroup = this.fb.group({
      name: ['', Validators.required],
    });
  }

  goBack() {
    this.location.back();
  }

  createVehicleType() {
    this.type = {
      name:''
    }
    if(this.formGroup.valid){
      this.type.name =  this.formGroup.get('name').value;
      this.vts.createType(this.type);
      if(!this.listType.includes(this.type)){
        this.listType.push(this.type)
      }
    }
    }

}
