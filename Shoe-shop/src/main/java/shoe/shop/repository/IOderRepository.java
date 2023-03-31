package shoe.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shoe.shop.dto.oder.OderView;
import shoe.shop.dto.oder.TotalPrice;
import shoe.shop.entity.oderProduct.Oder;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface IOderRepository extends JpaRepository<Oder, Long> {
    @Query(value = "SELECT product_id as productId, quantity, avatar_product as avatarProduct, price_product as priceProduct, name_product as nameProduct, account_id as accountId, oder_id as oderId, sizes as sizes, price_product * quantity as totalPrice\n" +
            "FROM oder where account_id=:idAccount\n" +
            "GROUP BY product_id;", nativeQuery = true)
    List<OderView> getAllOder(@Param("idAccount") Long idAccount);

    @Query(value = "SELECT SUM(oder.quantity * oder.price_product) as totalPrice\n" +
            "FROM oder where account_id=:idAccount", nativeQuery = true)
    TotalPrice totalPrice(@Param("idAccount") Long idAccount);

    Oder findAllByAccount_AccountIdAndProduct_ProductId(Long accountId, Long productId);
    @Modifying
    @Query(value = "update oder set quantity= :quantity where oder_id = :oderId ", nativeQuery = true)
    void updateOder(@Param("oderId") Long oderId, @Param("quantity") int quantity);
}

