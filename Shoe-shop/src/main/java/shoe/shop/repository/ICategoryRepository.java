package shoe.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shoe.shop.entity.product.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
