package com.sunil.datamodel.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class SalePurchaseVO {
    private int buyerId;
    private int productId;
    private int amount;
    private int price;
    private Date saleDate;
    private int sold;
    private int couponId;

    @Override
    public String toString() {
        return String.format(
                "SaleRegisterVO[buyerId=%d, productId=%d, amount=%d, price=%d, saleDate='%s', sold=%d, coupon=%d]",
                this.buyerId, this.productId, this.amount, this.price, this.saleDate, this.sold, this.couponId
        );
    };
};
