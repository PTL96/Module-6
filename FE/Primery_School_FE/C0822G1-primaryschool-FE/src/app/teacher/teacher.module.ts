import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TeacherRoutingModule } from './teacher-routing.module';
import { TeacherListComponent } from './teacher-list/teacher-list.component';
import { TeacherUpdateComponent } from './teacher-update/teacher-update.component';


@NgModule({
  declarations: [TeacherListComponent, TeacherUpdateComponent],
  imports: [
    CommonModule,
    TeacherRoutingModule
  ]
})
export class TeacherModule { }
