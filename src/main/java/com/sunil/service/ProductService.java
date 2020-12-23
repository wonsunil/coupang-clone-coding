package com.sunil.service;

import com.sunil.datamodel.ProductTotalReviewCount;
import com.sunil.datamodel.ProductTotalReviewRate;
import com.sunil.datamodel.ReviewGroupByProductId;
import com.sunil.datamodel.dto.ProductDTO;
import com.sunil.datamodel.vo.ProductRegisterVO;
import com.sunil.model.Product;
import com.sunil.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    };

    public ProductDTO productByProductId(int productId) throws Exception{
        Optional<Product> searchedProduct = this.productRepository.findById(productId);
        ProductDTO product = new ProductDTO(searchedProduct.orElseThrow(() -> new Exception("존재하지 않는 상품 아이디입니다")));

        ReviewGroupByProductId reviewCountGroupData = this.productRepository.getReviewCountByProductId(productId);
        ReviewGroupByProductId reviewRateGroupData = this.productRepository.getReviewRateByProductId(productId);

        if(reviewCountGroupData != null) {
            ProductTotalReviewCount reviewCount = new ProductTotalReviewCount(reviewCountGroupData);
            ProductTotalReviewRate reviewRate = new ProductTotalReviewRate(reviewRateGroupData);

            Optional<ProductTotalReviewCount> reviewTotalReviewCount = Optional.ofNullable(reviewCount);
            Optional<ProductTotalReviewRate> reviewTotalRate = Optional.ofNullable(reviewRate);

            product.setReviews(reviewTotalReviewCount.get().getTotalReviewCount());
            product.setRate(reviewTotalRate.get().getTotalRate());
        }else {
            product.setReviews(0);
            product.setRate((float) 0.0);
        };

        return product;
    };

    public List<ProductDTO> products() {
        List<ProductDTO> products = this.productRepository.findAll().stream().map(ProductDTO::new).collect(Collectors.toList());

        for(ProductDTO product : products) {
            ReviewGroupByProductId reviewCountGroupData = this.productRepository.getReviewCountByProductId(product.getProductId());
            ReviewGroupByProductId reviewRateGroupData = this.productRepository.getReviewRateByProductId(product.getProductId());

            if(reviewCountGroupData != null) {
                ProductTotalReviewCount reviewCount = new ProductTotalReviewCount(reviewCountGroupData);
                ProductTotalReviewRate reviewRate = new ProductTotalReviewRate(reviewRateGroupData);

                Optional<ProductTotalReviewCount> reviewTotalReviewCount = Optional.ofNullable(reviewCount);
                Optional<ProductTotalReviewRate> reviewTotalRate = Optional.ofNullable(reviewRate);

                product.setReviews(reviewTotalReviewCount.get().getTotalReviewCount());
                product.setRate(reviewTotalRate.get().getTotalRate());
            }else {
                product.setReviews(0);
                product.setRate((float) 0.0);
            };
        };

        return products;
    };

    public int createProduct(ProductRegisterVO product) {
        Product createProduct = Product.builder()
                .categoryId(product.getCategoryId())
                .sellerId(product.getSellerId())
                .name(product.getName())
                .amount(product.getAmount())
                .price(product.getPrice())
                .imageUrl("/basic_product.png")
                .build();

        this.productRepository.save(createProduct);
        this.productRepository.flush();

        return createProduct.getProductId();
    };

    public void initializeProducts() {
        Product product1 = Product.builder()
                .categoryId(1)
                .sellerId(1)
                .name("컴퓨터")
                .amount(2)
                .price(130000)
                .imageUrl("/basic_product.png")
                .build();

        Product product2 = Product.builder()
                .categoryId(2)
                .sellerId(3)
                .name("기타")
                .amount(1)
                .price(1200000)
                .imageUrl("/basic_product.png")
                .build();

        Product product3 = Product.builder()
                .categoryId(3)
                .sellerId(2)
                .name("마우스")
                .amount(1)
                .price(35000)
                .imageUrl("/basic_product.png")
                .build();

        this.productRepository.save(product1);
        this.productRepository.save(product2);
        this.productRepository.save(product3);

        this.productRepository.flush();
    };

    public void deleteProduct(int productId) {
        this.productRepository.deleteById(productId);
    };
};
