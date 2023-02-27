import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TimetableListComponent} from "./timetable-list/timetable-list.component";

const routes: Routes = [
  {path: '', component: TimetableListComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TimetableRoutingModule { }
