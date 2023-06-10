import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdministrationComponent } from './administration.component';
import { LoginComponent } from '../components/login/login.component';
import { HomeComponent } from '../components/home/home.component';
import { DetailUserComponent } from './users/detail-user/detail-user.component';

const routes: Routes = [
  { path: '', component: AdministrationComponent },
  {
    path: 'users',
    loadChildren: () =>
      import('./users/users.module').then((m) => m.UsersModule),
  },
  {
    path: 'vehicleTypes',
    loadChildren: () =>
      import('./vehicle-types/vehicle-types.module').then(
        (m) => m.VehicleTypesModule
      ),
  },
  {
    path: 'userSite',
    loadChildren: () =>
      import('../user-site/user-site.module').then((m) => m.UserSiteModule),
  },
  { path: 'login', component: LoginComponent },
  {
    path: 'fuel',
    loadChildren: () => import('./fuel/fuel.module').then((m) => m.FuelModule),
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AdministrationRoutingModule {}
