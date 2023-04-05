import {Component, HostListener, Input, OnInit} from '@angular/core';
import {ViewportScroller} from "@angular/common";
import {TokenStorageService} from "../../service/security/token-storage.service";
import {SecurityService} from "../../service/security/security.service";
import {Router} from "@angular/router";
import {Product} from "../../entity/product";
import {OderService} from "../../service/oder.service";
import {Oder} from "../../entity/oder";
import firebase from "firebase";
import User = firebase.User;

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  pageYoffSet = 0;
  isLoggedIn = false;
  user: any;
  username = '';
  name = "";
  role = '';
  length = 0;
  oder: Oder[] = [];
  cartItemCount: any;

  constructor(private scroll: ViewportScroller,
              private tokenStorageService: TokenStorageService,
              private securityService: SecurityService,
              private router: Router,
              private oderService: OderService) {
    this.securityService.getIsLoggedIn().subscribe(next => {
      this.isLoggedIn = next;
    });
    this.securityService.getUserLoggedIn().subscribe(next => {
      this.user = next;
      this.name = next.name;
    });
    if (tokenStorageService.getRole()) {
      this.role = tokenStorageService.getRole()[0];
      console.log(this.role);
    }
this.oderService.getAll(this.tokenStorageService.getIdAccount()).subscribe(ok=>{
  this.oder = ok;
})
  }

  ngOnInit(): void {
    this.isLoggedIn = this.tokenStorageService.getIsLogged();
    this.loader()
    this.oderService.getCartItemCount().subscribe(next => {
      this.cartItemCount = next;
    });


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

  scrollToTop() {
    this.scroll.scrollToPosition([0, 0]);
  }

  logout() {
    this.tokenStorageService.logout();
    this.securityService.setIsLoggedIn(null, false);
    this.router.navigateByUrl('/security');
  }


}
