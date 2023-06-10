import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserSiteComponent } from './user-site.component';
import { VehicleComponent } from './vehicle/vehicle.component';

const routes: Routes = [
  { path: '', component: UserSiteComponent },
  {
    path: 'userSite/chat',
    loadChildren: () => import('./chat/chat.module').then((m) => m.ChatModule),
  },
  { path: 'userSite/vehicle', component: VehicleComponent },
  {
    path: 'userSite/post',
    loadChildren: () => import('./post/post.module').then((m) => m.PostModule),
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class UserSiteRoutingModule {}
