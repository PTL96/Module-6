import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {OderListComponent} from "./oder-list/oder-list.component";
import {OderPaymentComponent} from "./oder-payment/oder-payment.component";
import {HistoryComponent} from "./history/history.component";
import {SuccessComponent} from "./success/success.component";

const routes: Routes = [
  {path:'',component:OderListComponent},
  {path:'payment/:id', component:OderPaymentComponent},
  {path:'success', component:SuccessComponent},
  {path:'history',component:HistoryComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CartRoutingModule { }
