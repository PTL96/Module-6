import {Category} from "./category";

export interface Product {
  productId?: number;
  productName?: string;
  description?: string;
  price?: number;
  avatar?: string;
  flagDelete?: boolean;
  category?: Category;
  quantity?: number;
}
