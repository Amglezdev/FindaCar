import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { adminGuardGuard } from './guards/admin-guard.guard';
import { authGuard } from './guards/auth.guard';
import { userSiteGuard } from './guards/user-site.guard';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'login', component:LoginComponent, canActivate:[authGuard]},
  {path:'signUp', component:SignUpComponent, canActivate:[authGuard]},
  {path:'administration', loadChildren: () => import('./administration/administration.module').then(m => m.AdministrationModule), canActivate: [adminGuardGuard]},
  { path: 'userSite', loadChildren: () => import('./user-site/user-site.module').then(m => m.UserSiteModule), canActivate:[userSiteGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
