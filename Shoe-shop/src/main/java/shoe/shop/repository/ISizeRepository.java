package shoe.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shoe.shop.entity.product.Size;

@Repository
public interface ISizeRepository extends JpaRepository<Size,Long> {
}
