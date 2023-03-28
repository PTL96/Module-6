import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ThongTinSan} from "../entity/thong-tin-san";

@Injectable({
  providedIn: 'root'
})
export class ThongtinsanService {

  constructor(private httpClient: HttpClient) { }
  URL_TT = ("http://localhost:8080/thongtinsan")

  getAll(): Observable<ThongTinSan[]>{
    return this.httpClient.get<ThongTinSan[]>(this.URL_TT)
  }
}
