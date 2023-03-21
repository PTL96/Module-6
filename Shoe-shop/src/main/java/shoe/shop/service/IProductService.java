package shoe.shop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import shoe.shop.dto.product.ProductView;
import shoe.shop.entity.product.Product;

public interface IProductService {
    Page<ProductView> getAllProduct(String name, String category, Pageable pageable);


    void save(Product product);

    Product findByIdProduct(Long id);

    void deleteProduct(Long id);
}
