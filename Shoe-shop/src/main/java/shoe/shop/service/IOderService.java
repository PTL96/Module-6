package shoe.shop.service;

import shoe.shop.entity.oderProduct.Oder;
import shoe.shop.entity.product.Product;

public interface IOderService {
    Oder findByProduct(Product product);

    void save(Oder oder);
}
