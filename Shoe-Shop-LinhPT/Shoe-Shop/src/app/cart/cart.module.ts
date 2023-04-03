import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CartRoutingModule } from './cart-routing.module';
import { OderListComponent } from './oder-list/oder-list.component';
import {FormsModule} from "@angular/forms";
import {NgxPaginationModule} from "ngx-pagination";
import { OderPaymentComponent } from './oder-payment/oder-payment.component';


@NgModule({
  declarations: [OderListComponent, OderPaymentComponent],
    imports: [
        CommonModule,
        CartRoutingModule,
        FormsModule,
        NgxPaginationModule
    ]
})
export class CartModule { }
