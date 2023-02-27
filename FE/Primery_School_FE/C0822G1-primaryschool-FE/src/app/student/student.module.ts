import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StudentRoutingModule } from './student-routing.module';
import { StudentListComponent } from './student-list/student-list.component';
import { StudentCreateComponent } from './student-create/student-create.component';
import { StudentUpdateComponent } from './student-update/student-update.component';
import { StudentDetailComponent } from './student-detail/student-detail.component';
import { StudentDeleteComponent } from './student-delete/student-delete.component';


@NgModule({
  declarations: [StudentListComponent, StudentCreateComponent, StudentUpdateComponent, StudentDetailComponent, StudentDeleteComponent],
  imports: [
    CommonModule,
    StudentRoutingModule
  ]
})
export class StudentModule { }
