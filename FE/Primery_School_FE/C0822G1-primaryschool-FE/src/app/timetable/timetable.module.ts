import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TimetableRoutingModule } from './timetable-routing.module';
import { TimetableListComponent } from './timetable-list/timetable-list.component';
import { TimetableTeacherComponent } from './timetable-teacher/timetable-teacher.component';


@NgModule({
  declarations: [TimetableListComponent, TimetableTeacherComponent],
  imports: [
    CommonModule,
    TimetableRoutingModule
  ]
})
export class TimetableModule { }
