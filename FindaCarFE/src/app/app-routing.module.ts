import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { AdminSiteGuard} from './guards/admin-site.guard';
import { UserSiteGuard } from './guards/user-site.guard';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'login', component:LoginComponent},
  {path:'signUp', component:SignUpComponent},
  {path:'administration', loadChildren: () => import('./administration/administration.module').then(m => m.AdministrationModule), canActivate: [AdminSiteGuard]},
  { path: 'userSite', loadChildren: () => import('./user-site/user-site.module').then(m => m.UserSiteModule), canActivate:[UserSiteGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
