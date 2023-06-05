import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Location } from '@angular/common';
import { Router } from '@angular/router';
import { User } from 'src/app/entities/user';
import { UserService } from 'src/app/services/user.service';
//import bcrypt from 'bcryptjs';
import { take, map } from 'rxjs';
import * as $ from 'jquery';
import { user } from 'src/environments/environments';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  user: User;

  test: any;

  constructor(
    private formBuilder: FormBuilder,
    private location: Location,
    private router: Router,
    private us: UserService
  ) {}

  ngOnInit() {
    console.log('Entrado en login component');
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
    });
  }

  async login() {
    console.log(this.user);
    if (this.loginForm.valid) {
      try {
        let buffer = this;
        this.user = {
          mail: '',
          password: '',
          id: 0,
          name: '',
          phoneNumber: '',
          rol: {
            name: '',
          },
          surname: '',
        };
        this.user.mail = this.loginForm.get('email').value;
        this.user.password = this.loginForm.get('password').value;
        console.log(this.user);
        await this.us
          .getUserByMailAndPassword(this.user)
          .then(async function (resp) {
            buffer.user = await resp.json();
            if ((await buffer.user) != null) {
              user.id = buffer.user.id;
              user.mail = buffer.user.mail;
              user.name = buffer.user.name;
              user.phoneNumber = buffer.user.phoneNumber;
              user.rol = buffer.user.rol;
              user.surname = buffer.user.surname;
              if (buffer.user.rol.name == 'Administrador') {
                user.rol.name = buffer.user.rol.name;
                console.log(user.name)
                buffer.router.navigate(['/administration']);
              } else {
                user.rol.name = buffer.user.rol.name;
                console.log(buffer.user)
                buffer.router.navigate(['/userSite']);
              }
            } else {
              console.log('Usuario no existente');
            }
          });
      } catch (error) {
        console.log(error);
      }
    }
  }


  // async encryptPassword(password: string): Promise<string> {
  //   const saltRounds = 10; // Número de rondas de sal
  //   const salt = await bcrypt.genSalt(saltRounds);
  //   const hash = await bcrypt.hash(password, salt);
  //   return hash;
  // }
}
