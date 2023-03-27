import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {Oder} from "../entity/oder";
import {Product} from "../entity/product";
import {TokenStorageService} from "./security/token-storage.service";
import {ProductDto} from "../entity/product-dto";
const ID_ACCOUNT_KEY = 'Id_Account_key';

@Injectable({
  providedIn: 'root'
})
export class OderService {

  constructor(private httpClient: HttpClient, private tokenStorageService: TokenStorageService) {
  }

  URL_ODER = ("http://localhost:8080/oder/addToCart")

  // add(product: Product): Observable<Oder> {
  //   return this.httpClient.post<Oder>(this.URL_ODER, product)
  // }

  add(product: Product,size: number): Observable<Oder> {
    let oder:Oder = {
      oderId: 0,
      sizes: size,
      quantity:1,
      priceProduct: product.price,
      productName:product.productName,
      avatar:product.avatar,
      account_id :this.tokenStorageService.getIdAccount(),
      product_id: product.productId
    }
    return this.httpClient.post<Oder>(this.URL_ODER, oder);
  }
}
