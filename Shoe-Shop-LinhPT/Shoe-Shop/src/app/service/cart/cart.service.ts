import {Injectable} from '@angular/core';
import {Product} from "../../entity/product";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor() {
  }

  items : Product[] = [];

  addCart(product: Product) {
    this.items.push(product)
  }

  getItems() {
    return this.items;
  }

  deteteCart(id: number) {
    this.items.splice(id);
    return this.items;
  }
}
