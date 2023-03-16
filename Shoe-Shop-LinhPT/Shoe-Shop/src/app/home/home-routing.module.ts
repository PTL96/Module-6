import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BodyComponent} from "./body/body.component";
import {ShoeDetailComponent} from "./shoe-detail/shoe-detail.component";

const routes: Routes = [
  {path:'', component:BodyComponent},
  {path:'detail', component:ShoeDetailComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
