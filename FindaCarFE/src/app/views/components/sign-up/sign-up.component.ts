import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Location } from '@angular/common';
import { User } from 'src/app/entities/user';
import { UserService } from 'src/app/services/user.service';
import { Role } from 'src/app/entities/role';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';

//import bcrypt from 'bcryptjs';


@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css'],
})
export class SignUpComponent implements OnInit {
  constructor(private formBuilder: FormBuilder, private location: Location, private us:UserService, private router:Router, private cookieService:CookieService) {}

  signUpForm: FormGroup;
  user: User;
  role:Role = {
    name:'Usuario'
  };

  ngOnInit() {
    const isLogged = this.cookieService.check('userData');

    if (isLogged) {
      this.router.navigate(['/userSite']);
    }
    this.signUpForm = this.formBuilder.group({
      name: ['', Validators.required],
      surname: ['', Validators.required],
      phoneNumber: ['', Validators.required],
      mail: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      rol: [this.role],
      security:['', Validators.required]
    });
  }

  signUp() {
    try {
      if (this.signUpForm.valid) {
        this.user = this.signUpForm.value;
        if(this.us.createUser(this.user)){
         this.router.navigate['/login']

        }else{
          console.log('No se ha creado')
        }
      }
    } catch (error) {}
  }

  goBack() {
    this.location.back();
  }

  // //Encriptador para contraseñas
  // async encryptPassword(password: string): Promise<string> {
  //   const saltRounds = 10; // Número de rondas de sal
  //   const salt = await bcrypt.genSalt(saltRounds);
  //   const hash = await bcrypt.hash(password, salt);
  //   return hash;
  // }
}
