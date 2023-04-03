import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {OderListComponent} from "./oder-list/oder-list.component";
import {OderPaymentComponent} from "./oder-payment/oder-payment.component";

const routes: Routes = [
  {path:'',component:OderListComponent},
  {path:'payment', component:OderPaymentComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CartRoutingModule { }
