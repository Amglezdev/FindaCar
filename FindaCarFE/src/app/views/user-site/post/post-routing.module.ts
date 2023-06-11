import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PostComponent } from './post.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { PostDetailComponent } from './post-detail/post-detail.component';
import { DeletePostComponent } from './delete-post/delete-post.component';
import { ConfirmDeleteComponent } from '../../administration/users/confirm-delete/confirm-delete.component';

const routes: Routes = [
  { path: '', component: PostComponent },
  { path: 'post/deletePost/:id', component: DeletePostComponent },
  { path: 'post/createPost', component: CreatePostComponent },
  { path: 'post/detailPost/:id', component: PostDetailComponent },
  { path: 'post/confirmDelete/:id', component: ConfirmDeleteComponent },
];
//userSite/post/confirmDelete/1

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PostRoutingModule {}
