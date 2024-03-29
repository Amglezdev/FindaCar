import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { get } from 'jquery';
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
    private location: Location,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.id = this.arm.snapshot.paramMap.get('id');
    this.getUserById(this.id);
  }

  deleteUser() {
    try {
      this.us.deleteUser(this.user);
      this.router.navigate(['/administration/users']);
    } catch (error) {
      console.log(error);
    }
  }

  goBack() {
    this.location.back();
  }
  async getUserById(id: string) {
    await this.us.getUserById(Number(id)).subscribe((resp) => {
      this.user = resp;
    });
  }
}
