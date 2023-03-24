import {Component, HostListener, Input, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {Product} from "../../entity/product";
import {ViewportScroller} from "@angular/common";
import {CategoryService} from "../../service/category.service";
import {Category} from "../../entity/category";
import Swal from "sweetalert2";
import {Cart} from "../../entity/cart";
import {OderService} from "../../service/oder.service";
import {Oder} from "../../entity/oder";


@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {
  pageSize: Product[] = [];
  size: number = 9;
  first: any;
  last: any;
  pageYoffSet = 0;
  name: string = '';
  category: string = '';
  categoryList: Category[] = []
  cart: Cart = {price: 0, quantity: 0};
  carts: Cart[] = [];
 // product:Product = {};

  constructor(private productService: ProductService,
              private scroll: ViewportScroller,
              private categoryService: CategoryService,
              private oderService: OderService) {
    this.categoryService.getAll().subscribe(data => {
      this.categoryList = data;
    })
  }

  ngOnInit(): void {
    this.getAllProduct(this.size);
  }

  @HostListener('window:scroll', ['$event']) onScroll() {
    this.pageYoffSet = window.pageYOffset;
  }

  getAllProduct(size: number) {
    this.productService.getAll(this.name, this.category, size).subscribe(data => {
      if (data != null) {
        this.pageSize = data.content
        this.size = data.size
        this.first = data.first
        this.last = data.last
      }
    })
  }

  addToCart(product: Product) {
    this.oderService.add(product).subscribe((oder:Oder)=>{
      console.log("Đã thêm vào giỏ"+ oder)
    });
  }


  scrollProduct() {
    this.scroll.scrollToPosition([0, 1200]);
  }


}
