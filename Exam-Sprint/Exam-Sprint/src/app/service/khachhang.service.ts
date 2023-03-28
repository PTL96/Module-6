import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {KhachHang} from "../entity/khach-hang";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class KhachhangService {

  constructor(private httpClient: HttpClient) { }
  URL_KH = ("http://localhost:8080/khachhang")

  getAll(): Observable<KhachHang[]>{
    return this.httpClient.get<KhachHang[]>(this.URL_KH)
  }
}
