package shoe.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoe.shop.entity.product.Category;
import shoe.shop.repository.ICategoryRepository;
import shoe.shop.service.ICategoryService;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category findByIdCategory(Long id) {
        return iCategoryRepository.findById(id).get();
    }
}
