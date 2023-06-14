import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VehiclesComponent } from './vehicles.component';
import { CreateVehicleComponent } from './create-vehicle/create-vehicle.component';
import { UpdateVehicleComponent } from './update-vehicle/update-vehicle.component';
import { DeleteVehicleComponent } from './delete-vehicle/delete-vehicle.component';

const routes: Routes = [{ path: '', component: VehiclesComponent },
{path:'createVehicle', component:CreateVehicleComponent},
{path:'updateVehicle/:id', component:UpdateVehicleComponent},
{path:'deleteVehicle/:id', component:DeleteVehicleComponent}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VehiclesRoutingModule { }
