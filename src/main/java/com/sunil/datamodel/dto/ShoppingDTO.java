package com.sunil.datamodel.dto;

import com.sunil.model.Shopping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ShoppingDTO {
    private int userId;
    private int amount;
    private int productId;

    public ShoppingDTO(Shopping shopping) {
        this.userId = shopping.getUserId();
        this.amount = shopping.getAmount();
        this.productId = shopping.getProductId();
    };

    @Override
    public String toString() {
        return String.format(
                "Shopping[userId=%d, amount=%d, productId=%d]",
                this.userId, this.amount, this.productId
        );
    };
};
