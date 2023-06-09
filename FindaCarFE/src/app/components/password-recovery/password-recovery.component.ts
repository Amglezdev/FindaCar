import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { UserService } from 'src/app/services/user.service';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { User } from 'src/app/entities/user';

@Component({
  selector: 'app-password-recovery',
  templateUrl: './password-recovery.component.html',
  styleUrls: ['./password-recovery.component.css'],
})
export class PasswordRecoveryComponent implements OnInit {
  user: User;
  passwordRecoveryForm: FormGroup;

  constructor(
    private cookieService: CookieService,
    private us: UserService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {}
  ngOnInit(): void {
    const isLogged = this.cookieService.check('userData');

    if (isLogged) {
      this.router.navigate(['/userSite']);
    }
    this.passwordRecoveryForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      security: ['', Validators.required],
      newPassword: ['', Validators.required],
    });
  }

  async recoverPassword() {
    if (this.passwordRecoveryForm.valid) {
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
          security: '',
        };
        this.user.mail = this.passwordRecoveryForm.get('email').value;
        this.user.password = this.passwordRecoveryForm.get('newPassword').value;
        this.user.security = this.passwordRecoveryForm.get('security').value;
        await this.us
          .changePassword(this.user)
          .then(async function (resp) {
            buffer.user = await resp.json();
            if ((await buffer.user) != null) {
              buffer.cookieService.set('userData', JSON.stringify(buffer.user));
              if (buffer.user.rol.name == 'Administrador') {
                buffer.router.navigate(['/administration']);
              } else {
                buffer.router.navigate(['/userSite']);
              }
            } else {
            }
          });
      } catch (error) {
      }
    }
  }
}
