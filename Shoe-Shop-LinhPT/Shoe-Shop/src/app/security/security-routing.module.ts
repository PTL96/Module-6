import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {AcountCreateComponent} from "./acount-create/acount-create.component";

const routes: Routes = [
  {path: '', component:LoginComponent},
  {path:'create', component:AcountCreateComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SecurityRoutingModule { }
