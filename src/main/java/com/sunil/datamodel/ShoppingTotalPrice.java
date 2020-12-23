package com.sunil.datamodel;

import lombok.Getter;

@Getter
public class ShoppingTotalPrice {
    int totalPrice;

    public ShoppingTotalPrice(ShoppingGroupByUserId group) {
        this.totalPrice = group.getTotalPrice();
    };
}
