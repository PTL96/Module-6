import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Sanbong} from "../entity/sanbong";

@Injectable({
  providedIn: 'root'
})
export class SanbongService {

  constructor(private httpClient: HttpClient) { }

  URL_SAN = ("http://localhost:8080/sanbong")

  getAll(): Observable<Sanbong[]>{
    return this.httpClient.get<Sanbong[]>(this.URL_SAN);
  }

  delete(id: number | undefined): Observable<Sanbong[]> {
    debugger
    return this.httpClient.delete<Sanbong[]>(this.URL_SAN + '/' + id);
  }

  save(sanBong: Sanbong): Observable<Sanbong> {
    return this.httpClient.post<Sanbong>(this.URL_SAN +'/save', sanBong);
  }

  search(tenSan: string, thongTinSan: string): Observable<Sanbong[]> {
    return this.httpClient.get<Sanbong[]>(this.URL_SAN + "?tenSan_like=" + tenSan + "&thongTinSan.khuVuc_like=" + thongTinSan)
  }
}
