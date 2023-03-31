import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Size} from "../entity/size";

@Injectable({
  providedIn: 'root'
})
export class SizeService {

  constructor(private httpClient: HttpClient) {
  }

  URL_SIZE = ("http://localhost:8080/size")

  getAll(): Observable<Size[]> {
    return this.httpClient.get<Size[]>(this.URL_SIZE);
  }

}
