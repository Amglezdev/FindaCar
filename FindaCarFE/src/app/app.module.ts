import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { PostComponent } from './user-site/post/post.component';
import { DetailPostComponent } from './user-site/detail-post/detail-post.component';
import { VehicleComponent } from './user-site/vehicle/vehicle.component';
import { FavoritesComponent } from './user-site/favorites/favorites.component';
import { UserService } from './services/user.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ChatDetailComponent } from './user-site/chat/chat-detail/chat-detail.component';
import { FuelService } from './services/fuel.service';
import { VehicleService } from './services/vehicle.service';
import { CookieService } from 'ngx-cookie-service';
import { RoleService } from './services/role.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    SignUpComponent,
    PostComponent,
    DetailPostComponent,
    VehicleComponent,
    FavoritesComponent,
    ChatDetailComponent,
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
