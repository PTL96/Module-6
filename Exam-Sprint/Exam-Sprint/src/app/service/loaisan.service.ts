import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {LoaiSan} from "../entity/loai-san";

@Injectable({
  providedIn: 'root'
})
export class LoaisanService {

  constructor(private httpClient: HttpClient) { }
  URL_LS = ("http://localhost:8080/loaisan")
  getAll(): Observable<LoaiSan[]>{
    return this.httpClient.get<LoaiSan[]>(this.URL_LS)
  }
}
