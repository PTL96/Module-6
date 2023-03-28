import {Component, OnInit} from '@angular/core';
import {Sanbong} from "../entity/sanbong";
import {SanbongService} from "../service/sanbong.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-san-bong-list',
  templateUrl: './san-bong-list.component.html',
  styleUrls: ['./san-bong-list.component.css']
})
export class SanBongListComponent implements OnInit {
  sanBong: Sanbong[] = [];
  temp: Sanbong = {};
  umberPage: number = 0;
  totalPages = 0;
  size: number = 3;
  constructor(private sanbongService: SanbongService,
              private toast: ToastrService) {
  }

  ngOnInit(): void {
    this.getAllSan()
  }

  getAllSan() {
    this.sanbongService.getAll().subscribe(data => {
      this.sanBong = data;
    })
  }

  deleteSanBong(id: number | undefined): void {
    this.sanbongService.delete(id).subscribe(data => {
      this.toast.success('Bạn đã xóa thành công', 'Thông báo', {
        positionClass: 'toast-top-center',
        timeOut: 3000
      },);
      this.ngOnInit()
    });
  }
}
