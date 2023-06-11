import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './views/components/home/home.component';
import { LoginComponent } from './views/components/login/login.component';
import { SignUpComponent } from './views/components/sign-up/sign-up.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { VehicleComponent } from './views/user-site/vehicle/vehicle.component';

import { UserService } from './services/user.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';

import { FuelService } from './services/fuel.service';
import { VehicleService } from './services/vehicle.service';
import { CookieService } from 'ngx-cookie-service';
import { RoleService } from './services/role.service';
import { PasswordRecoveryComponent } from './views/components/password-recovery/password-recovery.component';
import { VehiclePicturesComponent } from './views/user-site/vehicle-pictures/vehicle-pictures.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    SignUpComponent,
    VehicleComponent,
    PasswordRecoveryComponent,
    VehiclePicturesComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    RouterModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [
    UserService,
    FuelService,
    VehicleService,
    CookieService,
    RoleService,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
