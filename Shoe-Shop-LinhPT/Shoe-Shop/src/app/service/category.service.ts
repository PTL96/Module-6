import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "../entity/category";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private httpClient: HttpClient) { }

  URL_CATE = ("http://localhost:8080/category")

  getAll():Observable<Category[]>{
    return this.httpClient.get<Category[]>(this.URL_CATE);
  }
}
