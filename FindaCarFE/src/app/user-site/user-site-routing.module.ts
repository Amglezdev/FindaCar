import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserSiteComponent } from './user-site.component';
import { PostComponent } from './post/post.component';
import { DetailPostComponent } from './detail-post/detail-post.component';

const routes: Routes = [{ path: '', component: UserSiteComponent },
{path:'posts', component:PostComponent},
{ path: 'detailPost/:id', component: DetailPostComponent },
{ path: 'chat', loadChildren: () => import('./chat/chat.module').then(m => m.ChatModule) },
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserSiteRoutingModule { }
