import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CartRoutingModule } from './cart-routing.module';
import { OderListComponent } from './oder-list/oder-list.component';
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [OderListComponent],
    imports: [
        CommonModule,
        CartRoutingModule,
        FormsModule
    ]
})
export class CartModule { }
