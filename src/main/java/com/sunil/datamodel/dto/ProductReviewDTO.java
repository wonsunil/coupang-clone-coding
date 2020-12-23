package com.sunil.datamodel.dto;

import com.sunil.model.Product;
import com.sunil.model.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
public class ProductReviewDTO {
    private int productId;
    private int categoryId;
    private int sellerId;
    private String name;
    private int amount;
    private int price;
    private String imageUrl;
    private float rate;
    private Collection<Review> reviews;

    public ProductReviewDTO(Product product) {
        this.productId = product.getProductId();
        this.categoryId = product.getCategoryId();
        this.sellerId = product.getSellerId();
        this.name = product.getName();
        this.amount = product.getAmount();
        this.price = product.getPrice();
        this.imageUrl = product.getImageUrl();
    };

    @Override
    public String toString() {
        return String.format(
                "ProductDTO[productId=%d, categoryId=%d, sellerId=%d, name='%s', amount=%d, price=%d, imageUrl='%s']",
                this.productId, this.categoryId, this.sellerId, this.name, this.amount, this.price, this.imageUrl
        );
    };
}
