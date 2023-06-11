import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserSiteComponent } from './user-site.component';
import { VehicleComponent } from './vehicle/vehicle.component';
import { VehiclePicturesComponent } from './vehicle-pictures/vehicle-pictures.component';


const routes: Routes = [
  { path: '', component: UserSiteComponent },
  { path: 'userSite/vehicle', component: VehicleComponent },
  {
    path: 'userSite/post',
    loadChildren: () => import('./post/post.module').then((m) => m.PostModule),
  },
  { path: 'userSite/vehiclePictures', component: VehiclePicturesComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class UserSiteRoutingModule {}
