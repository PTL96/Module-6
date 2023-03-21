import {Component, HostListener, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Product} from "../../entity/product";
import {ViewportScroller} from "@angular/common";
import {CartService} from "../../service/cart/cart.service";

@Component({
  selector: 'app-shoe-detail',
  templateUrl: './shoe-detail.component.html',
  styleUrls: ['./shoe-detail.component.css']
})
export class ShoeDetailComponent implements OnInit {
  temp: Product = {};
  pageYoffSet =0;
  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private scroll: ViewportScroller,
              private cartService: CartService) {
    this.activatedRoute.paramMap.subscribe(next => {
      const id = next.get("id")
      if (id != null) {
        this.productService.findById(parseInt(id)).subscribe(data => {
          this.temp = data;
          console.log(this.temp)
        })
      }
    })
  }

  @HostListener('window:scroll', ['$event']) onScroll() {
    this.pageYoffSet = window.pageYOffset;
  }
  scrollProduct() {
    this.scroll.scrollToPosition([0, 1200]);
  }

  ngOnInit(): void {
    window.scrollTo(0, 690)
  }

  pushProduct(product: Product) {
    this.cartService.addCart(product);
    window.sessionStorage.setItem('cartItems', JSON.stringify(this.cartService.items));
  }

}
