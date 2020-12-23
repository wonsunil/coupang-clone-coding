package com.sunil.service;

import com.sunil.datamodel.dto.ProductDTO;
import com.sunil.datamodel.dto.CategoryDTO;
import com.sunil.datamodel.vo.CategoryRegisterVO;
import com.sunil.model.Category;
import com.sunil.repository.CategoryRepository;
import com.sunil.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class CategoryService {
    private CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    };

    public CategoryDTO categoryById(int categoryId) throws Exception{
        Optional<Category> searchedCategory = this.categoryRepository.findById(categoryId);

        return new CategoryDTO(searchedCategory.orElseThrow(() -> new Exception("존재하지 않는 카테고리 아이디입니다")));
    };

    public List<CategoryDTO> categories() {
        return this.categoryRepository.findAll().stream().map(CategoryDTO::new).collect(Collectors.toList());
    };

    public int createCategory(CategoryRegisterVO category) {
        Category createCategory = Category.builder()
                .categoryName(category.getCategoryName())
                .build();

        this.categoryRepository.save(createCategory);
        this.categoryRepository.flush();

        return createCategory.getCategoryId();
    };

    public void deleteCategory(int categoryId) {
        this.categoryRepository.deleteById(categoryId);
    };

    public void initializeCategories() {
        Category category1 = Category.builder()
                .categoryName("전자제품")
                .build();

        Category category2 = Category.builder()
                .categoryName("의류")
                .build();

        Category category3 = Category.builder()
                .categoryName("도서류")
                .build();

        Category category4 = Category.builder()
                .categoryName("식료품")
                .build();

        Category category5 = Category.builder()
                .categoryName("문구")
                .build();

        this.categoryRepository.save(category1);
        this.categoryRepository.save(category2);
        this.categoryRepository.save(category3);
        this.categoryRepository.save(category4);
        this.categoryRepository.save(category5);

        this.categoryRepository.flush();
    };

    public List<ProductDTO> productsByCategory(int categoryId) {
        return this.productRepository.findByCategoryId(categoryId).stream().map(ProductDTO::new).collect(Collectors.toList());
    };
};
