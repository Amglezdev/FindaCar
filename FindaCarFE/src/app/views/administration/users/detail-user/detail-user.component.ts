import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from 'src/app/entities/user';
import { UserService } from 'src/app/services/user.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-detail-user',
  templateUrl: './detail-user.component.html',
  styleUrls: ['./detail-user.component.css'],
})
export class DetailUserComponent implements OnInit {
  id: string;
  user: User;
  isModalVisible: boolean = false;


  constructor(private us: UserService, private arm: ActivatedRoute, private location:Location) {}

  ngOnInit(): void {
    this.id = this.arm.snapshot.paramMap.get('id');
    this.us.getUserById(Number(this.id)).subscribe((resp) => {
      this.user = resp;
    });
  }

  deleteUser(id:number){
    try{
      this.us.deleteUser(id);
    } catch{

    }
  }
  goBack(){
    this.location.back();
  }

showConfirmModal() {
  this.isModalVisible = true;
}

hideConfirmModal() {
  this.isModalVisible = false;
}



}
