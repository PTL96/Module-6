package shoe.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shoe.shop.entity.product.WareHouse;

@Repository
public interface IWareHouseRepository extends JpaRepository<WareHouse, Long> {
}
