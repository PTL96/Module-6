import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {BehaviorSubject, Observable, throwError} from "rxjs";
import {Oder} from "../entity/oder";
import {Product} from "../entity/product";
import {TokenStorageService} from "./security/token-storage.service";
import {TotalPrice} from "../entity/total-price";
import {Account} from "../entity/account/account";

const ID_ACCOUNT_KEY = 'Id_Account_key';

@Injectable({
  providedIn: 'root'
})
export class OderService {
  constructor(private httpClient: HttpClient, private tokenStorageService: TokenStorageService) {
  }

  URL_ODER = ("http://localhost:8080/oder")
  URL_HISTORY = ("http://localhost:8080/oder/history")
  URL_ACCOUNT = ("http://localhost:8080/api/auth")

  private cartItems: Oder[] = [];
  private cartItemCount = new BehaviorSubject(0);

  getCart() {
    return this.cartItems;
  }

  getCartItemCount() {
    return this.cartItemCount;
  }

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
    this.cartItems.push(oder);
    this.cartItemCount.next(this.cartItemCount.value + 1);
    return this.httpClient.post<Oder>(this.URL_ODER + '/addToCart', oder);
  }


  getAll(idAccount: any): Observable<Oder[]> {

    return this.httpClient.get<Oder[]>(this.URL_ODER + '?idAccount=' + idAccount);
  }

  getAllTotalPrice(idAccount: number): Observable<TotalPrice> {
    return this.httpClient.get<TotalPrice>(this.URL_ODER + '/total?idAccount=' + idAccount)
  }

  delete(id: number | undefined): Observable<Oder> {
    this.cartItemCount.next(this.cartItemCount.value - 1);
    return this.httpClient.delete<Oder>(this.URL_ODER + '/delete' + id)
  }


  update(id: number, quantity: number) {
    return this.httpClient.get(this.URL_ODER + '/update?id=' + id + '&quantity=' + quantity)
  }

  payment(idAccount: number): Observable<any> {
    return this.httpClient.put(this.URL_ODER + '/payment', {accountId: idAccount})
  }

  findByIdAccount(id: number): Observable<Account> {
    return this.httpClient.get<Account>(this.URL_ACCOUNT + '/' + id);
  }

  getAllHistory(idAccount: number): Observable<Oder[]> {
    return this.httpClient.get<Oder[]>(this.URL_HISTORY + '?idAccount=' + idAccount)
  }

  updateCustomer(account: Account): Observable<Account> {
    return this.httpClient.put<Account>(this.URL_ACCOUNT + '/account' + account.accountId, account)
  }
}
