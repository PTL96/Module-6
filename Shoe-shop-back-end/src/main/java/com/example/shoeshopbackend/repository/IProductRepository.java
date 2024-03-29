package com.example.shoeshopbackend.repository;


import com.example.shoeshopbackend.dto.product.ProductView;
import com.example.shoeshopbackend.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT product_name as productName, category_name as categoryName, quantitys, p.product_id as productId, avatar , price , description\n" +
            "            FROM product as p\n" +
            "                     INNER JOIN category ON p.category_id = category.category_id\n" +
            "                     INNER JOIN ware_house on p.product_id = ware_house.product_id\n" +
            "            where flag_delete = true and category_name like concat('%',:category,'%')\n" +
            "               and p.product_name like concat('%', :name, '%') order by p.product_id desc",
            countQuery = "SELECT product_name as productName, category_name as categoryName, quantitys\n" +
                    "                    FROM `product` as p\n" +
                    "                           INNER JOIN category ON p.category_id = category.category_id\n" +
                    "                           INNER JOIN ware_house on p.product_id = ware_house.product_id\n" +
                    "                    where flag_delete = true and category_name like concat('%',:category,'%')\n" +
                    "   and p.product_name like concat('%',:name,'%') order by p.product_id desc", nativeQuery = true)
    Page<ProductView> findAllPage(@Param("name") String name, @Param("category") String category, Pageable pageable);

}
