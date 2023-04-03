import {Component, OnInit} from '@angular/core';
import {OderService} from "../../service/oder.service";
import {render} from "creditcardpayments/creditCardPayments";
import {TotalPrice} from "../../entity/total-price";
import {ToastrService} from "ngx-toastr";
import {TokenStorageService} from "../../service/security/token-storage.service";
import {OderView} from "../../entity/oder-view";
import {Payment} from "../../entity/payment";
import {ShareService} from "../../service/security/share.service";

@Component({
  selector: 'app-oder-payment',
  templateUrl: './oder-payment.component.html',
  styleUrls: ['./oder-payment.component.css']
})
export class OderPaymentComponent implements OnInit {
  totalPrice: TotalPrice = {};
  idAccount: any;
  USDTotal: any = 0;
  oderView: OderView[] = [];
  p = 0;

  constructor(private oderService: OderService,
              private toast: ToastrService,
              private tokenStorageService: TokenStorageService,
              private share: ShareService) {
  }


  ngOnInit(): void {
    if (this.tokenStorageService.getToken()) {
      this.idAccount = this.tokenStorageService.getIdAccount()
      console.log(this.idAccount)
    }
    this.getTotalPrice()
    this.getALlOder()
  }

  getTotalPrice() {

    this.oderService.getAllTotalPrice(this.idAccount).subscribe(ok => {
      this.totalPrice = ok;
      this.USDTotal = (ok.totalPrice);
      render(
        {
          id: "#myPaypalButtons",
          currency: "USD",
          value: (this.USDTotal / 23000).toFixed(2),
          onApprove: (details) => {
            this.oderService.payment(this.idAccount).subscribe(next => {
              this.toast.info('Thanh toán thành công', 'Thành Công', {
                timeOut: 1000,
                positionClass: 'toast-top-center',
              });
              this.share.getClickEvent();
            })
          }
        }
      )
    })
  }

  getALlOder() {
    this.oderService.getAll(this.idAccount).subscribe(data => {
      this.oderView = data;
      console.log(this.oderView)
    })
  }


}
