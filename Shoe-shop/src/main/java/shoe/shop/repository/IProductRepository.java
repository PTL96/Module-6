package shoe.shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shoe.shop.dto.product.ProductView;
import shoe.shop.entity.product.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT product_name as productName, category_name as categoryName, quantitys, p.product_id as productId, avatar , price , description\n" +
            "            FROM product as p\n" +
            "                     INNER JOIN category ON p.category_id = category.category_id\n" +
            "                     INNER JOIN ware_house on p.product_id = ware_house.product_id\n" +
            "            where flag_delete = true and category_name like concat('%',:category,'%')\n" +
            "               and p.product_name like concat('%', :name, '%')",
            countQuery = "SELECT product_name as productName, category_name as categoryName, quantitys\n" +
                    "                    FROM `product` as p\n" +
                    "                           INNER JOIN category ON p.category_id = category.category_id\n" +
                    "                           INNER JOIN ware_house on p.product_id = ware_house.product_id\n" +
                    "                    where flag_delete = true and category_name like concat('%',:category,'%')\n" +
                    "   and p.product_name like concat('%',:name,'%')", nativeQuery = true)


//    @Query(value = "SELECT product_name  as productName,\n" +
//            "       category_name as categoryName,\n" +
//            "       quantitys,\n" +
//            "       product_id  as productId,\n" +
//            "       avatar,\n" +
//            "       price,\n" +
//            "       description\n" +
//            "FROM product as p\n" +
//            "         INNER JOIN category ON p.category_id = category.category_id\n" +
//            "         INNER JOIN ware_house on p.product_id = ware_house.product_id\n" +
//            "         INNER JOIN oder o on p.product_id = o.product_id\n" +
//            "         inner join account a on o.account_id = a.account_id\n" +
//            "where flag_delete = true\n" +
//            "  and category_name like concat('%', :category, '%')\n" +
//            "  and p.product_name like concat('%', :name, '%')",
//            countQuery = "SELECT product_name as productName, category_name as categoryName, quantitys\n" +
//                    "                    FROM `product` as p\n" +
//                    "                           INNER JOIN category ON p.category_id = category.category_id\n" +
//                    "                           INNER JOIN ware_house on p.product_id = ware_house.product_id\n" +
//                    "         INNER JOIN oder o on p.product_id = o.product_id\n" +
//                    "         inner join account a on o.account_id = a.account_id\n" +
//                    "                    where flag_delete = true and category_name like concat('%',:category,'%')\n" +
//                    "   and p.product_name like concat('%',:name,'%')", nativeQuery = true)
    Page<ProductView> findAllPage(@Param("name") String name, @Param("category") String category, Pageable pageable);

}
