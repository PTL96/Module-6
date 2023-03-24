import {Component, HostListener, OnInit} from "@angular/core";
import {Cart} from "../../entity/cart";
import {ViewportScroller} from "@angular/common";
import {ShareService} from "../../service/security/share.service";
import {TokenStorageService} from "../../service/security/token-storage.service";


@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.css']
})


export class CartListComponent implements OnInit {
  pageYoffSet = 0;
  cart: Cart[] = []
  length = 0;
  quantitys = 1
  total = 0;
totalProduct = 0;
  constructor(private scroll: ViewportScroller,
              private share: ShareService,
              private tokenStorageService: TokenStorageService) {

  }

  ngOnInit(): void {
    window.scrollTo(0, 690)
    if (this.tokenStorageService.getCart() == undefined) {
    } else {
      this.cart = this.tokenStorageService.getCart();
      this.loading()
      this.length = this.cart.length
    }
  }


  loading() {
    this.quantitys = 1;
    this.total = 0;
    for (let i = 0; i < this.cart.length; i++) {
      this.quantitys += this.cart[i].quantitys
      this.total += (this.cart[i].quantitys * this.cart[i].price)
      // this.totalProduct = (this.cart[i].quantitys * this.cart[i].price)
      console.log(this.total)
      console.log(this.cart[i].quantitys)
    }
  }

  @HostListener('window:scroll', ['$event']) onScroll() {
    this.pageYoffSet = window.pageYOffset;
  }

  scrollProductBack() {
    window.scrollTo(0, 690)
  }


  delete(id: number) {
    this.cart.splice(id)
    this.tokenStorageService.setCart(this.cart)
    this.loading()
  }

  upQuantity(index: number) {
    this.cart[index].quantitys += 1;
    this.tokenStorageService.setCart(this.cart)
    this.loading();
    this.share.sendClickEvent()
  }

  downQuantity(index: number) {
    if (this.cart[index].quantitys == 1) {
      this.cart.splice(index, 1)
    } else {
      this.cart[index].quantitys -= 1;
    }
    this.tokenStorageService.setCart(this.cart)
    this.loading();
    this.share.sendClickEvent()
  }


}
