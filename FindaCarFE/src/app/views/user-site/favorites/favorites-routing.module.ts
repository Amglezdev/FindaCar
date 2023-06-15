import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FavoritesComponent } from './favorites.component';
import { FavoriteDetailComponent } from './favorite-detail/favorite-detail.component';

const routes: Routes = [{ path: '', component: FavoritesComponent },
{path:'favoriteDetail/:id', component:FavoriteDetailComponent}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FavoritesRoutingModule { }
