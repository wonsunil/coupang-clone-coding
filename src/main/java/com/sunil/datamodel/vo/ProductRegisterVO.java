package com.sunil.datamodel.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductRegisterVO {
    private int productId;
    private int categoryId;
    private int sellerId;
    private String name;
    private int amount;
    private int price;
    private String imageUrl;
    private float rate;

    @Override
    public String toString() {
        return String.format(
                "ProductRegisterVO[productId=%d, categoryId=%d, sellerId=%d, name='%s', amount=%d, price=%d, imageUrl='%s']",
                this.productId, this.categoryId, this.sellerId, this.name, this.amount, this.price, this.imageUrl
        );
    };
};
