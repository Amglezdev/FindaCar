import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VehicleTypesComponent } from './vehicle-types.component';

const routes: Routes = [{ path: '', component: VehicleTypesComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VehicleTypesRoutingModule { }
