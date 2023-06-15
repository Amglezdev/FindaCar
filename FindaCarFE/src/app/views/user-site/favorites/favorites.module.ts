import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FavoritesRoutingModule } from './favorites-routing.module';
import { FavoritesComponent } from './favorites.component';
import { FavoriteDetailComponent } from './favorite-detail/favorite-detail.component';
import { UserSiteModule } from '../user-site.module';


@NgModule({
  declarations: [
    FavoritesComponent,
    FavoriteDetailComponent
  ],
  imports: [
    CommonModule,
    FavoritesRoutingModule,
    UserSiteModule
  ]
})
export class FavoritesModule { }
