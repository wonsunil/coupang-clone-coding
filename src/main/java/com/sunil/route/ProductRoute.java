package com.sunil.route;

import com.sunil.datamodel.dto.ProductDTO;
import com.sunil.datamodel.vo.ProductRegisterVO;
import com.sunil.service.ProductService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRoute {
    private final ProductService productService;

    @Autowired
    public ProductRoute(ProductService productService) {
        this.productService = productService;
    };

    @ApiOperation(value = "상품 기초 생성")
    @GetMapping("/initialize")
    public void initialize() {
        this.productService.initializeProducts();
    };

    @ApiOperation(value = "상품 전체 조회")
    @GetMapping("")
    public List<ProductDTO> getProducts() {
        return this.productService.products();
    };

    @ApiOperation(value = "상품 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId", value = "상품 ID", required = true, dataType = "string"),
    })
    @GetMapping("/{productId}")
    public ProductDTO getProduct(@PathVariable(value = "productId") String productId) throws Exception {
        return this.productService.productByProductId(Integer.parseInt(productId));
    };

    @ApiOperation(value = "상품 생성")
    @PostMapping("")
    public int createProduct(ProductRegisterVO product) {
        return this.productService.createProduct(product);
    };

    @ApiOperation(value = "상품 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId", value = "상품 ID", required = true, dataType = "string"),
    })
    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable(value = "productId") String productId) {
        this.productService.deleteProduct(Integer.parseInt(productId));
    };
};
