import {ProductService} from "../../service/product.service";
import {CategoryService} from "../../service/category.service";
import {Category} from "../../entity/category";
import {OderService} from "../../service/oder.service";
import {SecurityService} from "../../service/security/security.service";
import {TokenStorageService} from "../../service/security/token-storage.service";
import {ProductDto} from "../../entity/product-dto";
import {Product} from "../../entity/product";
import {Component, HostListener, OnInit} from "@angular/core";
import {ViewportScroller} from "@angular/common";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {ProductHot} from "../../entity/product-hot";


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
  productHot: ProductHot[] = [];
  checkQuantity = false;

  constructor(private productService: ProductService,
              private scroll: ViewportScroller,
              private categoryService: CategoryService,
              private oderService: OderService,
              private securityService: SecurityService,
              private tokenStorageService: TokenStorageService,
              private router: Router,
              private toast: ToastrService
  ) {
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
    this.getAllProductHot();
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
        console.log(data)
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
      this.toast.warning('Vui lòng đăng nhập', 'Hãy Đăng Nhập', {
        timeOut: 1000,
        positionClass: 'toast-top-center',
      });
      this.router.navigateByUrl('/security')
    } else {
      this.oderService.add(product, 1, 37).subscribe(ok => {
        this.toast.info('Đã thêm giỏ hàng', 'Đã Thêm', {
          timeOut: 1000,
          positionClass: 'toast-top-center',
        });
      }, err => {
        this.checkQuantity = err;
        this.toast.warning('Hiện tại chúng tôi không đủ hàng', 'Xin lỗi', {
          timeOut: 2000,
          positionClass: 'toast-top-center',
        });

      });
    }
  }

  getAllProductHot() {
    this.productService.getAllHot().subscribe(data => {
      this.productHot = data;
      console.log(this.productHot)
    })
  }

  scrollProduct() {
    this.scroll.scrollToPosition([0, 1200]);
  }


}
