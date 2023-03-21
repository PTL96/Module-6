package shoe.shop.service;

import shoe.shop.entity.product.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategory();

    Category findByIdCategory(Long id);
}
