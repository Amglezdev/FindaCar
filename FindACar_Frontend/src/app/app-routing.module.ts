import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignUpModule } from './auth/sign-up/sign-up.module';
import { AuthModule } from './auth/auth.module';

const routes: Routes = [
  {
    path:'login',
    loadChildren: () =>  import('./auth/login/login.module').then((m)=>m.LoginModule),
  },
  {
    path:'signUp',
    loadChildren: () =>  import('./auth/sign-up/sign-up.module').then((m)=>m.SignUpModule),
  },
  {
    path:'**',
    loadChildren: () =>  import('./auth/auth.module').then((m)=>m.AuthModule),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

