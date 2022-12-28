import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FacilityListComponent} from "./facility/facility-list/facility-list.component";
import {CustomerListComponent} from "./customer/customer-list/customer-list.component";
import {ContractManagementComponent} from "./contract/contract-management/contract-management.component";


const routes: Routes = [
  {
    path:"facility/list",
    component:FacilityListComponent
  },
  {
    path:"customer/list",
    component:CustomerListComponent
  },
  {
    path: "contract",
    component:ContractManagementComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
