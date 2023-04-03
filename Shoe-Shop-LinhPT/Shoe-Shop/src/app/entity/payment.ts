import {Oder} from "./oder";

export interface Payment {
  paymentId?:number;
  paymentMethod:string;
  datePayment:string;
  paymentStatus:boolean;
  account:Account;
  oder: Oder;
}
