import { Component, OnInit } from '@angular/core';
import { Fuel } from 'src/app/entities/fuel';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { FuelService } from 'src/app/services/fuel.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-fuel',
  templateUrl: './fuel.component.html',
  styleUrls: ['./fuel.component.css']
})
export class FuelComponent implements OnInit{

  listFuel: Fuel[];
  fuel: Fuel;
  formGroup: FormGroup;

  constructor(
    private fsi:FuelService,
    private location: Location,
    private fb: FormBuilder
  ) {}
  ngOnInit(): void {
    this.fsi.getAllTypes().subscribe((resp) => {
      this.listFuel = resp;
    })
    this.formGroup = this.fb.group({
      name: ['', Validators.required],
    });
  }
  createFuel() {
    this.fuel = {
      name:''
    }
    if(this.formGroup.valid){
      this.fuel.name =  this.formGroup.get('name').value;
      this.fsi.createFuel(this.fuel);
      if(!this.listFuel.includes(this.fuel)){
        this.listFuel.push(this.fuel)
      }
    }
    }

  goBack(){
    this.location.back();
  }
}
