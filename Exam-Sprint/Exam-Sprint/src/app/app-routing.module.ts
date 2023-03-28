import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SanBongListComponent} from "./san-bong-list/san-bong-list.component";
import {SanBongCreateComponent} from "./san-bong-create/san-bong-create.component";

const routes: Routes = [
  {path:'',component: SanBongListComponent},
  {path: 'create', component: SanBongCreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
