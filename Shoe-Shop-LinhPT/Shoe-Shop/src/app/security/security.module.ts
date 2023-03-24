import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SecurityRoutingModule } from './security-routing.module';
import { LoginComponent } from './login/login.component';
import { AcountCreateComponent } from './acount-create/acount-create.component';
import {ReactiveFormsModule} from "@angular/forms";
import { AccountEditComponent } from './account-edit/account-edit.component';


@NgModule({
  declarations: [LoginComponent, AcountCreateComponent, AccountEditComponent],
    imports: [
        CommonModule,
        SecurityRoutingModule,
        ReactiveFormsModule
    ]
})
export class SecurityModule { }
