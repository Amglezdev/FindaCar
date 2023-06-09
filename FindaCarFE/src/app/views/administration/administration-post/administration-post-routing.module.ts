import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdministrationPostComponent } from './administration-post.component';

const routes: Routes = [{ path: '', component: AdministrationPostComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdministrationPostRoutingModule { }
