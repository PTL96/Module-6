import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {KhuVuc} from "../entity/khu-vuc";
import {LoaiSan} from "../entity/loai-san";
import {ThongTinSan} from "../entity/thong-tin-san";
import {SanbongService} from "../service/sanbong.service";
import {ThongtinsanService} from "../service/thongtinsan.service";
import {LoaisanService} from "../service/loaisan.service";
import {KhuvucService} from "../service/khuvuc.service";
import {KhachhangService} from "../service/khachhang.service";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";

@Component({
  selector: 'app-san-bong-create',
  templateUrl: './san-bong-create.component.html',
  styleUrls: ['./san-bong-create.component.css']
})
export class SanBongCreateComponent implements OnInit {
  khuVuc: KhuVuc[] = [];
  loaiSan: LoaiSan[] = [];
  thongTinSan: ThongTinSan[] = [];


  formCreate: FormGroup = new FormGroup({
    id: new FormControl(''),
    tenSan: new FormControl('',[Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
    diaChi: new FormControl('',[Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
    thongTinSan: new FormControl('', [Validators.required])
  });

  constructor(private sanbongService: SanbongService,
              private thongtinsanService: ThongtinsanService,
              private loaisanService: LoaisanService,
              private khuvucService: KhuvucService,
              private khachhangService: KhachhangService,
              private toast: ToastrService,
              private router: Router) {
    this.thongtinsanService.getAll().subscribe(ok => {
      this.thongTinSan = ok;
    });
    this.loaisanService.getAll().subscribe(next => {
      this.loaiSan = next;
    });
    this.khuvucService.getAll().subscribe(kv => {
      this.khuVuc = kv;
    })

  }

  ngOnInit(): void {
  }

  createSanBong() {
    const sanBong = this.formCreate.value;
    if(this.formCreate.valid){
      this.sanbongService.save(sanBong).subscribe(data => {
        console.log(this.formCreate)
        this.toast.success('Thêm mới thành công', 'Thành Công', {positionClass: 'toast-top-center', timeOut: 3000},);
        this.router.navigateByUrl('/')
      })
    }else {
      this.toast.error('Vui lòng kiểm tra lại thông tin', 'Thất Bại', {positionClass: 'toast-top-center', timeOut: 3000},);

    }

  }
}
