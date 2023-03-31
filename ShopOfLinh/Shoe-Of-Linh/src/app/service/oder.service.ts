import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable, throwError} from "rxjs";
import {Product} from "../entity/product";
import {TokenStorageService} from "./security/token-storage.service";
import {TotalPrice} from "../entity/total-price";
import {Oder} from "../entity/oder";

const ID_ACCOUNT_KEY = 'Id_Account_key';

@Injectable({
  providedIn: 'root'
})
export class OderService {
  constructor(private httpClient: HttpClient, private tokenStorageService: TokenStorageService) {
  }

  URL_ODER = ("http://localhost:8080/oder")

  add(product: Product, size: number): Observable<Oder> {
    let oder: Oder = {
      oderId: 0,
      sizes: size,
      quantity: 1,
      priceProduct: product.price,
      productName: product.productName,
      avatar: product.avatar,
      account_id: this.tokenStorageService.getIdAccount(),
      product_id: product.productId
    }
    return this.httpClient.post<Oder>(this.URL_ODER + '/addToCart', oder);
  }

  getAll(idAccount: number): Observable<Oder[]> {

    return this.httpClient.get<Oder[]>(this.URL_ODER + '?idAccount=' + idAccount);
  }

  getAllTotalPrice(idAccount: number): Observable<TotalPrice> {
    return this.httpClient.get<TotalPrice>(this.URL_ODER + '/total?idAccount=' + idAccount)
  }

  delete(id: number | undefined): Observable<Oder> {
    return this.httpClient.delete<Oder>(this.URL_ODER + '/delete' + id)
  }

}
