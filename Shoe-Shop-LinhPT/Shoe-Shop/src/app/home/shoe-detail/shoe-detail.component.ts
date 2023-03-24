import {Component, HostListener, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Product} from "../../entity/product";
import {ViewportScroller} from "@angular/common";
import {SizeService} from "../../service/size.service";
import {Size} from "../../entity/size";
import {TokenStorageService} from "../../service/security/token-storage.service";
import {Cart} from "../../entity/cart";
import Swal from "sweetalert2";

@Component({
  selector: 'app-shoe-detail',
  templateUrl: './shoe-detail.component.html',
  styleUrls: ['./shoe-detail.component.css']
})
export class ShoeDetailComponent implements OnInit {
  temp: Product = {};
  pageYoffSet = 0;
  size: Size[] = [];
  // cart: Cart = {price: 0, quantitys: 0};
  carts: Cart[] = [];
  private id = 0;

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private scroll: ViewportScroller,
              private sizeService: SizeService,
              private tokenStorageService: TokenStorageService,
  ) {
    this.activatedRoute.paramMap.subscribe(next => {
      const id = next.get("id");
      if (id != null) {
        this.productService.findById(parseInt(id)).subscribe(data => {
          this.temp = data;
          console.log(this.temp)
        })
      }
    });
    this.sizeService.getAll().subscribe(next => {
      this.size = next;
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


  // addTocard(productId: number| undefined, avatar: string| undefined, price: number, productName: string) {
  //   if (this.tokenStorageService.getCart() != undefined) {
  //     this.carts = this.tokenStorageService.getCart()
  //     this.cart.id = productId;
  //     this.cart.imageProduct = avatar;
  //     this.cart.price = price
  //     this.cart.nameProduct = productName
  //     if (this.tokenStorageService.checkProducName(productName)) {
  //       this.tokenStorageService.upQuantity(this.id, this.carts)
  //     } else {
  //       this.cart.quantitys = 1;
  //       this.carts.push(this.cart)
  //       Swal.fire({
  //         position: 'top',
  //         icon: 'success',
  //         title: 'Đã thêm vào giỏ hàng',
  //         showConfirmButton: false,
  //         timer: 1000
  //       })
  //     }
  //     this.tokenStorageService.setCart(this.carts)
  //   } else {
  //     this.cart.id = productId;
  //     this.cart.imageProduct = avatar;
  //     this.cart.price = price
  //     this.cart.nameProduct = productName
  //     this.cart.quantitys = 1;
  //     this.carts.push(this.cart)
  //     Swal.fire({
  //       position: 'top',
  //       icon: 'success',
  //       title: 'Đã thêm vào giỏ hàng',
  //       showConfirmButton: false,
  //       timer: 1000
  //     })
  //     this.tokenStorageService.setCart(this.carts)
  //
  //   }
  // }

}
