import {Component, HostListener, Input, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {ViewportScroller} from "@angular/common";
import {CategoryService} from "../../service/category.service";
import {Category} from "../../entity/category";
import {OderService} from "../../service/oder.service";
import {Oder} from "../../entity/oder";
import {SecurityService} from "../../service/security/security.service";
import {TokenStorageService} from "../../service/security/token-storage.service";
import {ProductDto} from "../../entity/product-dto";
import {Product} from "../../entity/product";
import {Router} from "@angular/router";
import Swal from "sweetalert2";
import {ToastrService} from "ngx-toastr";


@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {
  pageSize: ProductDto[] = [];
  size: number = 9;
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
              private router: Router,
              private toast: ToastrService) {
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

  loader() {
    if (this.isLoggedIn) {
      this.securityService.getProfile(this.tokenStorageService.getIdAccount()).subscribe(
        next => this.user = next
      )
    }
  }

  addToCart(product: Product) {
    if (!this.tokenStorageService.getToken()) {
      Swal.fire({
        icon: 'error',
        position: 'top',
        width:'500px',
        title: 'Bạn Chưa Đăng Nhập',
        text: 'Vui lòng đăng nhập để tiếp tục',
      })
    } else {
      this.oderService.add(product, 37).subscribe(ok => {
        this.toast.success('Bạn đã xóa học sinh thành công', 'Thông báo', {positionClass: 'toast-top', timeOut: 3000},);

      });
    }

  }


  scrollProduct() {
    this.scroll.scrollToPosition([0, 1200]);
  }


}
