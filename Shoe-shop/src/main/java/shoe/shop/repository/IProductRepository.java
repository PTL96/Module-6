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

//    @Query(value = "SELECT product_name\n" +
//            "FROM `product`\n" +
//            "INNER JOIN category ON product.category_id = category.category_id where category_name =:category or product.product_name like concat('%',:name,'%') order by product_name ASC", nativeQuery = true,
//    countQuery = "FROM product_name\n" +
//            "         INNER JOIN category ON product.category_id = category.category_id\n" +
//            "where category_name = :name\n" +
//            "   or product.product_name like concat('%', 'Nike', '%')")
//    Page<Product> findAllPage(@Param("name") String name, @Param("category") String category, Pageable pageable);


    @Query(value = "SELECT product_name as productName, category_name as categoryName, product_id as productId, avatar , price , description , flag_delete as flagDelete , quantity\n" +
            "FROM `product`\n" +
            "         INNER JOIN category ON product.category_id = category.category_id\n" +
            "where category_name like concat('%',:category,'%')\n" +
            "   and product.product_name like concat('%', :name, '%')",
    countQuery = "SELECT product_name as productName, category_name as categoryName\n" +
            "FROM `product`\n" +
            "         INNER JOIN category ON product.category_id = category.category_id\n" +
            "where category_name like concat('%',:category,'%')\n" +
            "   and product.product_name like concat('%',:name,'%')",nativeQuery = true)
        Page<ProductView> findAllPage(@Param("name") String name, @Param("category") String category, Pageable pageable);

}
