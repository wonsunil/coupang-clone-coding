package com.sunil.datamodel.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ShoppingRegisterVO {
    private int userId;
    private int amount;
    private int productId;

    @Override
    public String toString() {
        return String.format(
                "Shopping[userId=%d, amount=%d, productId=%d]",
                this.userId, this.amount, this.productId
        );
    };
};
