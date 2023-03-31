import {Component, HostListener, OnInit} from '@angular/core';
import {ViewportScroller} from "@angular/common";
import {TokenStorageService} from "../../service/security/token-storage.service";
import {SecurityService} from "../../service/security/security.service";
import {Router} from "@angular/router";

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
  role = '';
  length = 0;
  count = 0;
  constructor(private scroll: ViewportScroller,
              private tokenStorageService: TokenStorageService,
              private securityService: SecurityService,
              private router: Router) {
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
  }

  ngOnInit(): void {
    this.isLoggedIn = this.tokenStorageService.getIsLogged();
    this.loader()
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
