package com.sunil.route;

import com.sunil.datamodel.dto.ProductDTO;
import com.sunil.datamodel.dto.CategoryDTO;
import com.sunil.datamodel.vo.CategoryRegisterVO;
import com.sunil.service.CategoryService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "카테고리 기초 생성")
    @GetMapping("/initialize")
    public void initialize() {
        this.categoryService.initializeCategories();
    };

    @ApiOperation(value = "카테고리 전체 조회")
    @GetMapping("")
    public List<CategoryDTO> getCategories() {
        return this.categoryService.categories();
    };

    @ApiOperation(value = "카테고리 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "카테고리 ID", required = true, dataType = "string"),
    })
    @GetMapping("/{categoryId}")
    public CategoryDTO category(@PathVariable(value = "categoryId") String categoryId) throws Exception {
        return this.categoryService.categoryById(Integer.parseInt(categoryId));
    };

    @ApiOperation(value = "카테고리 생성")
    @PostMapping
    public int createCategory(CategoryRegisterVO category) {
        return this.categoryService.createCategory(category);
    };

    @ApiOperation(value = "카테고리 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "카테고리 ID", required = true, dataType = "string"),
    })
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable(value = "categoryId") String categoryId) {
        this.categoryService.deleteCategory(Integer.parseInt(categoryId));
    };

    @ApiOperation(value = "카테고리별 상품 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "카테고리 ID", required = true, dataType = "string"),
    })
    @GetMapping("/{categoryId}/products")
    public List<ProductDTO> productsByCategory(@PathVariable(value = "categoryId") String categoryId) {
        return this.categoryService.productsByCategory(Integer.parseInt(categoryId));
    };
};
