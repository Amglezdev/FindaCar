import { Component, OnInit } from '@angular/core';
import { Role } from 'src/app/entities/role';
import { User } from 'src/app/entities/user';
import { RoleService } from 'src/app/services/role.service';
import { UserService } from 'src/app/services/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css'],
})
export class EditUserComponent implements OnInit {
  user: User;
  roles: Role[];

  constructor(
    private rs: RoleService,
    private us: UserService,
    private route: ActivatedRoute,
    private location:Location,
  ) {}

  ngOnInit(): void {
    const userId = this.route.snapshot.paramMap.get('id');
    this.getUser(Number(userId));
    this.getRoles();
  }

  getUser(id: number) {
    this.us.getUserById(Number(id)).subscribe((resp) => {
      this.user = resp;
    });
  }

  getRoles() {
    try {
      this.rs.getAllRoles().subscribe((resp) => {
        this.roles = resp;
      });
    } catch (error) {
      return null;
    }
  }

  editUser() {
    try {
      this.us.updateUser(this.user);
    } catch {}
  }

  goBack(){
    this.location.back();
  }
}
