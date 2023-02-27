import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TimetableRoutingModule } from './timetable-routing.module';
import { TimetableListComponent } from './timetable-list/timetable-list.component';


@NgModule({
  declarations: [TimetableListComponent],
  imports: [
    CommonModule,
    TimetableRoutingModule
  ]
})
export class TimetableModule { }
