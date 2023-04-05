import {Component, OnInit} from '@angular/core';
import {OderService} from "../../service/oder.service";
import {render} from "creditcardpayments/creditCardPayments";
import {TotalPrice} from "../../entity/total-price";
import {ToastrService} from "ngx-toastr";
import {TokenStorageService} from "../../service/security/token-storage.service";
import {OderView} from "../../entity/oder-view";
import {ShareService} from "../../service/security/share.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";
import {Account} from "../../entity/account/account";

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
  account: Account = {};
  accountId: any;
  p = 0;
  updateForm = new FormGroup({});

  constructor(private oderService: OderService,
              private toast: ToastrService,
              private tokenStorageService: TokenStorageService,
              private share: ShareService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe(ok => {
      const id = ok.get("id");
      if (id != null) {
        this.oderService.findByIdAccount(parseInt(id)).subscribe(next => {
          this.account = next;
          console.log(this.account)
          this.updateForm = new FormGroup({
            accountId: new FormControl(this.account.accountId),
            email: new FormControl(this.account.email),
            name: new FormControl(this.account.name),
            idCard: new FormControl(this.account.idCard),
            address: new FormControl(this.account.address),
            phoneNumber: new FormControl(this.account.phoneNumber),
            dateOfBirth: new FormControl(this.account.dateOfBirth),
            userName: new FormControl(this.account.userName)
          })
        })
      }
    })
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
    this.oderService.getAllTotalPrice(parseInt(this.tokenStorageService.getIdAccount())).subscribe(ok => {
      this.totalPrice = ok;
      console.log(ok)
      if (ok != null) {
        this.USDTotal = (ok.totalPrice);
      }
      render(
        {
          id: "#myPaypalButtons",
          currency: "USD",
          value: (this.USDTotal / 23000).toFixed(2),
          onApprove: (details) => {
            this.oderService.payment(this.idAccount).subscribe(next => {
              this.share.sendClickEvent();
              console.log(this.idAccount)
            });
            this.toast.info('Thanh toán thành công', 'Thành Công', {
              timeOut: 2000,
              positionClass: 'toast-top-center',
            });
            this.router.navigateByUrl('/cart/history')
          }
        }
      )
    });
  }

  getALlOder() {
    this.oderService.getAll(this.idAccount).subscribe(data => {
      this.oderView = data;
      console.log(this.oderView)
    })
  }

}
