import { Injectable } from '@angular/core';
import {TokenStorageService} from "./security/token-storage.service";

@Injectable({
  providedIn: 'root'
})

export class SendMailService {
email = '';
  constructor(private tokenStorageService: TokenStorageService) {
    this.email = this.tokenStorageService.getEmail();
  }

}
