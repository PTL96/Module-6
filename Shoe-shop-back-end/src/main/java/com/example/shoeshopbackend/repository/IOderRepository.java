package com.example.shoeshopbackend.repository;


import com.example.shoeshopbackend.dto.oder.HistoryDto;
import com.example.shoeshopbackend.dto.oder.OderView;
import com.example.shoeshopbackend.dto.oder.TotalPrice;
import com.example.shoeshopbackend.entity.Oder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface IOderRepository extends JpaRepository<Oder, Long> {
    @Query(value = "SELECT product_id as productId, quantity, avatar_product as avatarProduct, price_product as priceProduct, name_product as nameProduct, account_id as accountId, oder_id as oderId, sizes as sizes, price_product * quantity as totalPrice\n" +
            "FROM oder where payment = false and account_id=:idAccount and flag_delete = false\n" +
            "GROUP BY product_id;", nativeQuery = true)
    List<OderView> getAllOder(@Param("idAccount") Long idAccount);


    @Query(value = "SELECT SUM(oder.quantity * oder.price_product) as totalPrice\n" +
            "FROM oder where account_id=:idAccount and flag_delete = false and payment = false", nativeQuery = true)
    TotalPrice totalPrice(@Param("idAccount") Long idAccount);

    Oder findAllByAccount_AccountIdAndProduct_ProductId(Long accountId, Long productId);

    @Modifying
    @Query(value = "update oder set quantity= :quantity where oder_id = :oderId ", nativeQuery = true)
    void updateOder(@Param("oderId") Long oderId, @Param("quantity") int quantity);

    List<Oder> findByAccount_AccountId(Long accountId);

    @Modifying
    @Query(value = "SELECT price_product as priceProduct, name_product as nameProduct, account_id as accounId, oder_id as oderId, date_payment as datePayment,quantity, price_product * quantity as totalPrice\n" +
            "FROM oder where account_id=:idAccount and payment = true\n" +
            "GROUP BY product_id;", nativeQuery = true)
    List<HistoryDto> getHistory(@Param("idAccount") Long idAccount);
//    @Modifying
//    @Query(value = "SELECT ")
}

