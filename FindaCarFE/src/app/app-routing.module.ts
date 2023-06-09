import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './views/components/home/home.component';
import { LoginComponent } from './views/components/login/login.component';
import { SignUpComponent } from './views/components/sign-up/sign-up.component';
import { AdminSiteGuard } from './guards/admin-site.guard';
import { UserSiteGuard } from './guards/user-site.guard';
import { PasswordRecoveryComponent } from './views/components/password-recovery/password-recovery.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signUp', component: SignUpComponent },
  { path: 'passwordRecovery', component: PasswordRecoveryComponent },
  {
    path: 'administration',
    loadChildren: () =>
      import('./views/administration/administration.module').then(
        (m) => m.AdministrationModule
      ),
    canActivate: [AdminSiteGuard],
  },
  {
    path: 'userSite',
    loadChildren: () =>
      import('./views/user-site/user-site.module').then((m) => m.UserSiteModule),
    canActivate: [UserSiteGuard],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
