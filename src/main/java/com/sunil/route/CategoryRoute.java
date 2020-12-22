package com.sunil.route;

import com.sunil.datamodel.dto.CategoryDTO;
import com.sunil.datamodel.vo.CategoryRegisterVO;
import com.sunil.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryRoute {
    private final CategoryService categoryService;

    @Autowired
    public CategoryRoute(CategoryService categoryService) {
        this.categoryService = categoryService;
    };

    @GetMapping("/initialize")
    public void initialize() {
        this.categoryService.initializeCategories();
    };

    @GetMapping("")
    public List<CategoryDTO> getCategories() {
        return this.categoryService.categories();
    };

    @GetMapping("/{categoryId}")
    public CategoryDTO category(@PathVariable(value = "categoryId") String categoryId) throws Exception {
        return this.categoryService.categoryById(Integer.parseInt(categoryId));
    };

    @PostMapping
    public int createCategory(CategoryRegisterVO category) {
        return this.categoryService.createCategory(category);
    };

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable(value = "categoryId") String categoryId) {
        this.categoryService.deleteCategory(Integer.parseInt(categoryId));
    };
};
