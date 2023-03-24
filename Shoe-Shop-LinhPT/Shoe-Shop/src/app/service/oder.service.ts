import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Oder} from "../entity/oder";
import {Product} from "../entity/product";

@Injectable({
  providedIn: 'root'
})
export class OderService {

  constructor(private httpClient: HttpClient) { }

  URL_ODER = ("http://localhost:8080/oder/addToCart")

  add(product: Product): Observable<Oder> {
    return this.httpClient.post<Oder>(this.URL_ODER, product)
  }
}
