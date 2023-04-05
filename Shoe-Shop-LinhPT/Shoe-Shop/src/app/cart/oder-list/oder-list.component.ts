import {Component, HostListener, OnInit} from "@angular/core";
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
  p = 0;
  USDTotal: any = 0;
  oderIsEmpty: boolean = false;

  constructor(private scroll: ViewportScroller,
              private share: ShareService,
              private tokenStorageService: TokenStorageService,
              private oderService: OderService,
              public toast: ToastrService,
              ) {
    this.share.getClickEvent().subscribe(next => {
      this.getALlOder();
      this.getTotalPrice();
    })
  }

  ngOnInit(): void {
    window.scrollTo(0, 690)
    if (this.tokenStorageService.getToken()) {
      this.idAccount = this.tokenStorageService.getIdAccount()
      console.log(this.idAccount)
    }
    this.oderService.getAll(this.idAccount).subscribe(data => {
      this.oderView = data;
      this.oderIsEmpty = this.oderView == null;

    })
    this.getTotalPrice()
  }


  @HostListener('window:scroll', ['$event']) onScroll() {
    this.pageYoffSet = window.pageYOffset;
  }

  scrollProductBack() {
    window.scrollTo(0, 690)
  }

  getALlOder() {

  }

  getTotalPrice() {
    this.oderService.getAllTotalPrice(this.idAccount).subscribe(ok => {
      this.totalPrice = ok;
      this.USDTotal = (ok.totalPrice);
    })
  }

  deleteOder(id: number | undefined) {
    if (this.oderView != null)
      this.oderService.delete(id).subscribe(deteted => {
        this.toast.info('Đã xóa khỏi giỏ hàng', 'Đã Xóa', {
          timeOut: 1000,
          positionClass: 'toast-top-center',
        });
        this.oderService.getAll(this.idAccount).subscribe(data => {
          this.oderView = data;
          console.log(this.oderView)
        })
      })
  }

  changeQuantity(oderId: any, qty: string) {
    this.oderService.update(oderId, parseInt(qty)).subscribe(next => {
      this.share.sendClickEvent();
    })

  }
}
