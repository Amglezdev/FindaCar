import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PostComponent } from './post.component';
import { DeletePostComponent } from './delete-post/delete-post.component';

const routes: Routes = [{ path: '', component: PostComponent },
{path:'deletePost/:id', component:DeletePostComponent}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PostRoutingModule { }
