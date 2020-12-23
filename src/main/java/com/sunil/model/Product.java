package com.sunil.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(nullable = false)
    private int categoryId;

    @Column(nullable = false)
    private int sellerId;

    @Column
    private String name;

    @Column
    private int amount;

    @Column
    private int price;

    @Column
    private String imageUrl;

    @Column
    private float rate;

    @Column
    private int reviews;

    @Builder
    public Product(int categoryId, int sellerId, String name, int amount, int price, String imageUrl, int reviews) {
        this.categoryId = categoryId;
        this.sellerId = sellerId;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.imageUrl = imageUrl;
        this.reviews = reviews;
    };

    @Override
    public String toString() {
        return String.format(
                "Product[productId=%d, categoryId=%d, sellerId=%d, name='%s', amount=%d, price=%d, imageUrl='%s', reviews=%d]",
                this.productId, this.categoryId, this.sellerId, this.name, this.amount, this.price, this.imageUrl, this.reviews
        );
    };
};
