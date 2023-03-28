import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TokenStorageService} from "../../service/security/token-storage.service";
import {SecurityService} from "../../service/security/security.service";
import {ViewportScroller} from "@angular/common";
import {ShareService} from "../../service/security/share.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  errorMessage = '';
  roles: string[] = [];
  returnUrl = '/';
  errors = {username: '', password: ''};
  pageYoffSet = 0;
  loginForm: FormGroup = new FormGroup({
    username: new FormControl('', [Validators.required, Validators.minLength(3)]),
    password: new FormControl('', [Validators.required, Validators.minLength(3)]),
    rememberMe: new FormControl(false)
  });

  constructor(private router: Router,
              private tokenStorageService: TokenStorageService,
              private route: ActivatedRoute,
              private securityService: SecurityService,
              private shareService: ShareService,
              private scroll: ViewportScroller) { }

  ngOnInit(): void {
    window.scrollTo(0,690)
  }

  login(){
    this.errors = {username: '', password: ''};
    this.errorMessage = '';
    if (this.loginForm.valid) {
      this.securityService.login(this.loginForm.value).subscribe(
        data => {
          console.log(data);
          if (this.loginForm.value.rememberMe) {
            this.tokenStorageService.saveTokenLocal(data.token);
            this.tokenStorageService.saveUserLocal(data, data.email, data.id, data.username, data.name, data.roles, data.avatar, data.address, data.phoneNumber, data.dateOfBirth, data.idCard);
          } else {
            this.tokenStorageService.saveTokenSession(data.token);
            this.tokenStorageService.saveUserSession(data, data.email, data.id, data.username, data.name, data.roles, data.avatar, data.dateOfBirth, data.phoneNumber,data.address, data.idCard);
          }
          const user = this.tokenStorageService.getUser();
          this.securityService.setIsLoggedIn(user, true);
          const username = this.tokenStorageService.getUsername();
          this.roles = this.tokenStorageService.getRole();
          if(this.roles.indexOf('ROLE_CUSTOMER') > - 1) {
            this.router.navigateByUrl('/');
          }
          if(this.roles.indexOf('ROLE_ADMIN') > - 1) {
            this.router.navigateByUrl('/');
          }
          this.loginForm.reset();

           alert("")
          window.scrollTo(0,0)
        }, error => {

          if(error.status == 406){
            this.errorMessage = error.error.message;

            alert("")
          }
          this.securityService.isLoggedIn = false;
          if(error.error.errors){
            for (let i = 0; i < error.error.errors.length ; i++) {
              if (error.error.errors && error.error.errors[i].field === 'username') {
                this.errors.username = error.error.errors[i].defaultMessage;
              }
              if (error.error.errors && error.error.errors[i].field === 'password') {
                this.errors.password = error.error.errors[i].defaultMessage;
              }
            }
          }
        }
      );
    }
  }

}
