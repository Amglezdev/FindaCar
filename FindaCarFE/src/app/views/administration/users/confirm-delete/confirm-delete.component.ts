import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from 'src/app/entities/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-confirm-delete',
  templateUrl: './confirm-delete.component.html',
  styleUrls: ['./confirm-delete.component.css'],
})
export class ConfirmDeleteComponent implements OnInit {
  id: string;
  user: User;

  constructor(
    private us: UserService,
    private arm: ActivatedRoute,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.id = this.arm.snapshot.paramMap.get('id');
    this.us.getUserById(Number(this.id)).subscribe((resp) => {
      this.user = resp;
    });
  }

  delete() {
    try {
      this.us.deleteUser(Number(this.id));
    } catch (error) {
      console.log(error)
    }

  }

  goBack() {
    this.location.back();
  }
}
