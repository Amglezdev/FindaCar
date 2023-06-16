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
    private location: Location
  ) {}

  ngOnInit(): void {
    const userId = this.route.snapshot.paramMap.get('id');
    this.getUser(Number(userId));
    this.getRoles();
  }

  async getUser(id: number) {
    await this.us.getUserById(Number(id)).subscribe((resp) => {
      this.user = resp;
    });
  }

  async getRoles() {
    try {
      await this.rs.getAllRoles().subscribe((resp) => {
        this.roles = resp.filter(x => x.name != 'SuperAdministrador');
      });
      this.roles
    } catch (error) {
      return null;
    }
  }

  async editUser() {
    try {
      await this.us.updateUser(this.user);
      this.goBack();
    } catch {}
  }

  goBack() {
    this.location.back();
  }
}
