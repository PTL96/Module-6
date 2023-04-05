import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CartRoutingModule } from './cart-routing.module';
import { OderListComponent } from './oder-list/oder-list.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgxPaginationModule} from "ngx-pagination";
import { OderPaymentComponent } from './oder-payment/oder-payment.component';
import { HistoryComponent } from './history/history.component';
import { SuccessComponent } from './success/success.component';


@NgModule({
  declarations: [OderListComponent, OderPaymentComponent, HistoryComponent, SuccessComponent],
    imports: [
        CommonModule,
        CartRoutingModule,
        FormsModule,
        NgxPaginationModule,
        ReactiveFormsModule
    ]
})
export class CartModule { }
