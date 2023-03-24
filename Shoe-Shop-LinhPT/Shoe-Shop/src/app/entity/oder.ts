import {Product} from "./product";

export interface Oder {
  oderId?:number;
  nameProduct?:string;
  priceProduct:number
  avatarProduct?: string;
  quantity:number
  account?:Account;
  product?:Product;
}
