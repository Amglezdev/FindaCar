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

  constructor(
    private us: UserService,
    private arm: ActivatedRoute,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.id = this.arm.snapshot.paramMap.get('id');
    this.getUserById(this.id)
  }

  async getUserById(id: string) {
    await this.us.getUserById(Number(id)).subscribe((resp) => {
      this.user = resp;
    });
  }

  goBack() {
    this.location.back();
  }
}
