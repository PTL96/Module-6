package shoe.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import shoe.shop.entity.product.Category;
import shoe.shop.service.impl.CategoryService;

import java.util.List;

@Controller
@RequestMapping("category")
@CrossOrigin("*")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categoryList = categoryService.getAllCategory();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category category = categoryService.findByIdCategory(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
