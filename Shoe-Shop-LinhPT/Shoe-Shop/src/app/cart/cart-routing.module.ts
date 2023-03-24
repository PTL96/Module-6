import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {OderListComponent} from "./oder-list/oder-list.component";

const routes: Routes = [
  {path:'',component:OderListComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CartRoutingModule { }
