import {Component, HostListener, OnInit} from '@angular/core';
import {CartService} from "../../service/cart/cart.service";
import {Product} from "../../entity/product";
import {ViewportScroller} from "@angular/common";

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.css']
})
export class CartListComponent implements OnInit {
  items: Product[] = [];
  quantity: number = 0;
  totalPrice: number = 0;
  pageYoffSet = 0;


  constructor(private cartService: CartService,
              private scroll: ViewportScroller) {
  }

  ngOnInit(): void {
    window.scrollTo(0, 690)
    this.items = this.cartService.getItems();
    const itemCart = window.sessionStorage.getItem('itemCart')
    if(itemCart){
      this.items = JSON.parse(itemCart)
    }
  }

  deleteItems(id: number){
    this.items = this.cartService.deteteCart(id);
    window.sessionStorage.removeItem('itemCart')

}

  // totalQuantity() {
  //   let totalQuantity = 0;
  //   this.items.forEach(item=>{
  //     totalQuantity += item.quantity
  //   })
  // }

  getTotalPrice() {

  }

  @HostListener('window:scroll', ['$event']) onScroll() {
    this.pageYoffSet = window.pageYOffset;
  }
  scrollProductBack() {
    window.scrollTo(0,600)
  }
}
