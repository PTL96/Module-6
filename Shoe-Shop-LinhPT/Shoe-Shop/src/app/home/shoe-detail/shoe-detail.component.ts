import {Component, HostListener, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Product} from "../../entity/product";
import {ViewportScroller} from "@angular/common";
import {SizeService} from "../../service/size.service";
import {Size} from "../../entity/size";
import {TokenStorageService} from "../../service/security/token-storage.service";
import {SecurityService} from "../../service/security/security.service";
import {ToastrService} from "ngx-toastr";
import {OderService} from "../../service/oder.service";
import {ShareService} from "../../service/security/share.service";

@Component({
  selector: 'app-shoe-detail',
  templateUrl: './shoe-detail.component.html',
  styleUrls: ['./shoe-detail.component.css']
})
export class ShoeDetailComponent implements OnInit {
  temp: Product = {};
  pageYoffSet = 0;
  size: Size[] = [];
  private id = 0;
  isLoggedIn = false;
  user: any;
  checkQuantity = false;

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private scroll: ViewportScroller,
              private sizeService: SizeService,
              private tokenStorageService: TokenStorageService,
              private securityService: SecurityService,
              private toast: ToastrService,
              private oderService: OderService,
              private shareService: ShareService
  ) {
    this.activatedRoute.paramMap.subscribe(next => {
      this.securityService.getIsLoggedIn().subscribe(next => {
        this.isLoggedIn = next;
      });
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


  loader() {
    if (this.isLoggedIn) {
      this.securityService.getProfile(this.tokenStorageService.getIdAccount()).subscribe(
        next => this.user = next
      )
    }
  }

  addToCart(product: Product, quantity: any) {
    if (!this.tokenStorageService.getToken()) {
      this.toast.warning('Vui lòng đăng nhập', 'Hãy Đăng Nhập', {
        timeOut: 1000,
        positionClass: 'toast-top-center',
      });
      this.router.navigateByUrl('/security')
    } else{
      this.oderService.add(product, quantity, 37).subscribe(ok => {
        this.toast.info('Đã thêm giỏ hàng', 'Đã Thêm', {
          timeOut: 1000,
          positionClass: 'toast-top-center',
        });
        this.shareService.sendClickEvent()
        this.router.navigateByUrl('/cart')
      }, error => {
        this.checkQuantity = error;
        this.toast.warning('Số không hợp lệ hoặc hiện tại chúng tôi không đủ hàng', 'Xin lỗi', {
          timeOut: 2000,
          positionClass: 'toast-top-center',
        });

      });

    }

  }

}
