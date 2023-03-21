import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BodyComponent} from "./body/body.component";
import {ShoeDetailComponent} from "./shoe-detail/shoe-detail.component";
import {ShoeCreateComponent} from "./shoe-create/shoe-create.component";

const routes: Routes = [
  {path:'', component:BodyComponent},
  {path:'detail', component:ShoeDetailComponent},
  {path:'create', component:ShoeCreateComponent},
  {path:'detail/:id', component:ShoeDetailComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
