import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HeaderComponent } from './header/header.component';
import { BodyComponent } from './body/body.component';
import { FooterComponent } from './footer/footer.component';
import { ShoeDetailComponent } from './shoe-detail/shoe-detail.component';
import { ShoeCreateComponent } from './shoe-create/shoe-create.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ProfileComponent } from './profile/profile.component';


@NgModule({
  declarations: [HeaderComponent, BodyComponent, FooterComponent, ShoeDetailComponent, ShoeCreateComponent, ProfileComponent],
  exports: [
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class HomeModule { }
