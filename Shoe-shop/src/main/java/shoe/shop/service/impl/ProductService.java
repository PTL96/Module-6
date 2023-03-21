package shoe.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import shoe.shop.dto.product.ProductView;
import shoe.shop.entity.product.Product;
import shoe.shop.repository.IProductRepository;
import shoe.shop.service.IProductService;


@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<ProductView> getAllProduct(String name, String category, Pageable pageable) {
        return iProductRepository.findAllPage(name, category, pageable);
    }

    @Override
    public void save(Product product) {
        product.setFlagDelete(true);
        iProductRepository.save(product);
    }

    @Override
    public Product findByIdProduct(Long id) {
        return iProductRepository.findById(id).get();
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = this.findByIdProduct(id);
        product.setFlagDelete(false);
        iProductRepository.save(product);
    }


}
