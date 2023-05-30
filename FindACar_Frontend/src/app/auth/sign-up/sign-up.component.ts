import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AuthServicesService } from '../../services/auth-services.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { User } from 'src/app/entities/user';
import bcrypt from 'bcryptjs';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css'],
})
export class SignUpComponent implements OnInit {
  constructor(
    private http: HttpClient,
    private service: AuthServicesService,
    private formBuilder: FormBuilder
  ) {}

  signUpForm: FormGroup;
  user: User;

  ngOnInit() {
    this.signUpForm = this.formBuilder.group({
      name: ['', Validators.required],
      surname: ['', Validators.required],
      phoneNumber: ['', Validators.required],
      mail: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      roleId: [1],
    });
  }

  signUp() {
    try {
      if (this.signUpForm.valid) {
      }
    } catch (error) {}
  }

  //Encriptador para contraseñas
  async encryptPassword(password: string): Promise<string> {
    const saltRounds = 10; // Número de rondas de sal
    const salt = await bcrypt.genSalt(saltRounds);
    const hash = await bcrypt.hash(password, salt);
    return hash;
  }
}
