import {Component, OnInit} from '@angular/core';
import {SecurityService} from "../../service/security/security.service";
import {OderService} from "../../service/oder.service";
import {TokenStorageService} from "../../service/security/token-storage.service";
import {Account} from "../../entity/account/account";
import {FormControl, FormGroup} from "@angular/forms";
import {AccountRole} from "../../entity/account/account-role";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  idAccount: any;
  account: Account = {};
  updateForm: FormGroup = new FormGroup({});

  constructor(private securityService: SecurityService,
              private oderService: OderService,
              private tokenStorageService: TokenStorageService) {
    this.idAccount = this.tokenStorageService.getIdAccount()
    console.log(this.idAccount);
    this.oderService.findByIdAccount(parseInt(this.idAccount)).subscribe(next => {
      this.account = next;
      console.log(this.account)
      this.updateForm = new FormGroup({
        accountId: new FormControl(this.account.accountId),
        userName: new FormControl(this.account.userName),
        email: new FormControl(this.account.email),
        name: new FormControl(this.account.name),
        idCard: new FormControl(this.account.idCard),
        address: new FormControl(this.account.address),
        phoneNumber: new FormControl(this.account.phoneNumber),
        dateOfBirth: new FormControl(this.account.dateOfBirth),
        avatar: new FormControl(this.account.avatar),
      })
    })
  }

  ngOnInit(): void {
    window.scrollTo(0,690)

  }

}
