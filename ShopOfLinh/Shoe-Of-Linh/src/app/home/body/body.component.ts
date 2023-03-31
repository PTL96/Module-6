import {Component, HostListener, OnInit} from '@angular/core';
import {ProductDto} from "../../entity/product-dto";
import {Category} from "../../entity/category";
import {ProductService} from "../../service/product.service";
import {ViewportScroller} from "@angular/common";
import {CategoryService} from "../../service/category.service";
import {OderService} from "../../service/oder.service";
import {SecurityService} from "../../service/security/security.service";
import {TokenStorageService} from "../../service/security/token-storage.service";
import {Router} from "@angular/router";
import {Product} from "../../entity/product";

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {
  pageSize: ProductDto[] = [];
  size: number = 0;
  first: any;
  last: any;
  pageYoffSet = 0;
  name: string = '';
  category: string = '';
  categoryList: Category[] = []
  role = '';
  user: any;
  isLoggedIn = false;
  idAccount: any;

  constructor(private productService: ProductService,
              private scroll: ViewportScroller,
              private categoryService: CategoryService,
              private oderService: OderService,
              private securityService: SecurityService,
              private tokenStorageService: TokenStorageService,
              private router: Router) {
    this.categoryService.getAll().subscribe(data => {
      this.categoryList = data;
    });

    this.securityService.getIsLoggedIn().subscribe(next => {
      this.isLoggedIn = next;
    });
    this.securityService.getUserLoggedIn().subscribe(next => {
      this.user = next;
    });
    if (tokenStorageService.getRole()) {
      this.role = tokenStorageService.getRole()[0];
      console.log(this.role);
    }
    if (this.tokenStorageService.getIdAccount()) {
      this.idAccount = tokenStorageService.getIdAccount();
    }
  }

  ngOnInit(): void {
    this.isLoggedIn = this.tokenStorageService.getIsLogged();
    this.getAllProduct(this.size);
    this.loader()
  }

  getAllProduct(size: number) {
    this.productService.getAll(this.name, this.category, size).subscribe(data => {
      if (data != null) {
        this.pageSize = data.content
        this.size = data.size
        this.first = data.first
        this.last = data.last
        console.log(this.pageSize)
      }
    })
  }

  addToCart(product: Product) {
    if (!this.tokenStorageService.getToken()) {
      alert("vui lòng đăng nhập")
    } else {
      this.oderService.add(product, 37).subscribe(ok => {
        // this.toast.info('Đã thêm giỏ hàng', 'Đã Thêm', {
        //   timeOut: 1000,
        //   positionClass: 'toast-top-center',
        // });
      });
    }

  }

  loader() {
    if (this.isLoggedIn) {
      this.securityService.getProfile(this.tokenStorageService.getIdAccount()).subscribe(
        next => this.user = next
      )
    }
  }

  @HostListener('window:scroll', ['$event']) onScroll() {
    this.pageYoffSet = window.pageYOffset;
  }

  scrollProduct() {
    this.scroll.scrollToPosition([0, 1200]);
  }
}
