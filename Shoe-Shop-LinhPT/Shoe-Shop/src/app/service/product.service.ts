import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../entity/product";
import {ProductHot} from "../entity/product-hot";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient) {
  }

  URL_PRD = ("http://localhost:8080/product")
  URL_PRD_HOT = ("http://localhost:8080/oder/hot")

  getAll(name: string, category: string, size: number): Observable<any> {
    return this.httpClient.get<any>(this.URL_PRD + '?size=' + size + '&name=' + name + '&category=' + category);
  }

  save(product: Product): Observable<Product> {
    return this.httpClient.post<Product>(this.URL_PRD + '/create', product)
  }

  findById(id: number) {
    return this.httpClient.get(this.URL_PRD + '/' + id)
  }

  getAllHot(): Observable<ProductHot[]>{
    return this.httpClient.get<ProductHot[]>(this.URL_PRD_HOT)
  }
}
