import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TimetableRoutingModule } from './timetable-routing.module';
import { TimetableListComponent } from './timetable-list/timetable-list.component';
import { TimetableTeacherListComponent } from './timetable-teacher-list/timetable-teacher-list.component';


@NgModule({
  declarations: [TimetableListComponent, TimetableTeacherListComponent],
  imports: [
    CommonModule,
    TimetableRoutingModule
  ]
})
export class TimetableModule { }
