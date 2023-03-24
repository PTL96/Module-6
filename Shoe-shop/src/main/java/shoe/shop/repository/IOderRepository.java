package shoe.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import shoe.shop.entity.oderProduct.Oder;
import shoe.shop.entity.product.Product;

@Repository
public interface IOderRepository extends JpaRepository<Oder, Long> {
    Oder findByProduct(Product product);
}
