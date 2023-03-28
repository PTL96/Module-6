import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {KhuVuc} from "../entity/khu-vuc";

@Injectable({
  providedIn: 'root'
})
export class KhuvucService {

  constructor(private httpClient: HttpClient) { }
  URL_KV = ("http://localhost:8080/khuvuc")
  getAll(): Observable<KhuVuc[]>{
    return this.httpClient.get<KhuVuc[]>(this.URL_KV)
  }
}
