import {Component, HostListener, Input, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {Product} from "../../entity/product";
import {ViewportScroller} from "@angular/common";
import {CategoryService} from "../../service/category.service";
import {Category} from "../../entity/category";
import {CartService} from "../../service/cart/cart.service";

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

  constructor(private productService: ProductService,
              private scroll: ViewportScroller,
              private categoryService: CategoryService,
              private cartService: CartService) {
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

  scrollProduct() {
    this.scroll.scrollToPosition([0, 1200]);
  }



}
