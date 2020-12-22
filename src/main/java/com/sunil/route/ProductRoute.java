package com.sunil.route;

import com.sunil.datamodel.dto.ProductDTO;
import com.sunil.datamodel.vo.ProductRegisterVO;
import com.sunil.service.ProductService;
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

    @GetMapping("/initialize")
    public void initialize() {
        this.productService.initializeProducts();
    };

    @GetMapping("")
    public List<ProductDTO> getProducts() {
        return this.productService.products();
    };

    @GetMapping("/{productId}")
    public ProductDTO getProduct(@PathVariable(value = "productId") String productId) throws Exception {
        return this.productService.productByProductId(Integer.parseInt(productId));
    };

    @PostMapping("")
    public int createProduct(ProductRegisterVO product) {
        return this.productService.createProduct(product);
    };

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable(value = "productId") String productId) {
        this.productService.deleteProduct(Integer.parseInt(productId));
    };
};
