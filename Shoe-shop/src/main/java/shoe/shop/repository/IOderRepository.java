package shoe.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import shoe.shop.dto.oder.OderView;
import shoe.shop.entity.oderProduct.Oder;

import java.util.List;


@Repository
public interface IOderRepository extends JpaRepository<Oder, Long> {
//    @Query(value = "SELECT product_id, quantity, avatar_product, price_product, sizes as productSize, name_product, price_product * quantity as total_price\n" +
//            "FROM oder\n" +
//            "GROUP BY product_id;", nativeQuery = true)
//    List<OderView> getAllOder();
}

