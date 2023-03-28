import {Component, HostListener, OnDestroy, OnInit, ViewContainerRef} from "@angular/core";
import {ViewportScroller} from "@angular/common";
import {ShareService} from "../../service/security/share.service";
import {TokenStorageService} from "../../service/security/token-storage.service";
import {OderService} from "../../service/oder.service";
import {OderView} from "../../entity/oder-view";
import {TotalPrice} from "../../entity/total-price";
import {ToastrService} from "ngx-toastr";


@Component({
  selector: 'app-cart-list',
  templateUrl: 'oder-list.component.html',
  styleUrls: ['./oder-list.component.css']
})


export class OderListComponent implements OnInit {
  pageYoffSet = 0;
  oderView: OderView[] = [];
  length = 0;
  idAccount: any;
  totalPrice: TotalPrice = {};
  count = 0;

  constructor(private scroll: ViewportScroller,
              private share: ShareService,
              private tokenStorageService: TokenStorageService,
              private oderService: OderService,
              public toast: ToastrService,
              ) {}

  ngOnInit(): void {
    window.scrollTo(0, 690)
    if (this.tokenStorageService.getToken()) {
      this.idAccount = this.tokenStorageService.getIdAccount()
      console.log(this.idAccount)
    }
    this.getALlOder();
    this.getTotalPrice();
  }


  @HostListener('window:scroll', ['$event']) onScroll() {
    this.pageYoffSet = window.pageYOffset;
  }

  scrollProductBack() {
    window.scrollTo(0, 690)
  }

  getALlOder() {
    this.oderService.getAll(this.idAccount).subscribe(data => {
      this.oderView = data;
      console.log(this.oderView)
    })
  }

  getTotalPrice() {
    this.oderService.getAllTotalPrice(this.idAccount).subscribe(ok => {
      this.totalPrice = ok;
    })
  }

  deleteOder(id: number | undefined) {
    if (this.oderView != null)
      this.oderService.delete(id).subscribe(deteted => {
        this.toast.info('Đã xóa khỏi giỏ hàng', 'Đã Xóa', {
          timeOut: 1000,
          positionClass: 'toast-top-center',
        });
        this.ngOnInit();
      })
  }

}
