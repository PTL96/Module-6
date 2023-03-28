import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})


export class SecurityService {
  httpOptions: any;
  isLoggedIn = false;
  isLoggedInObservable = new Subject<boolean>();
  isUserObservable = new Subject<any>();

  constructor(private httpClient: HttpClient) {

    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      'Access-Control-Allow-Origin': 'http://localhost:4200',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
    };
  }

  URL_SCRT = ("http://localhost:8080/api/auth")

  login(obj: any): Observable<any> {
    return this.httpClient.post(this.URL_SCRT + '/sign-in', {
      username: obj.username,
      password: obj.password
    }, this.httpOptions);

  }
  public getProfile(id:string):Observable<Account> {
    return this.httpClient.get<Account>(this.URL_SCRT + '/profile/' + id)
  }
  setIsLoggedIn(user: any,isLoggedIn: boolean) {
    this.isLoggedInObservable.next(isLoggedIn);
    this.isUserObservable.next(user);
  }

  getUserLoggedIn(): Observable<any> {
    return this.isUserObservable.asObservable();
  }

  getIsLoggedIn(): Observable<boolean> {
    return this.isLoggedInObservable.asObservable();
  }
}
