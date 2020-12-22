package com.sunil.datamodel.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class SalePurchaseVO {
    private int saleId;
    private int buyerId;
    private int productId;
    private String name;
    private int price;
    private Date saleDate;
    private int sold;

    @Override
    public String toString() {
        return String.format(
                "SaleRegisterVO[saleId=%d, buryerId=%d, productId=%d, name='%s', price=%d, saleDate='%s', sold=%d]",
                this.saleId, this.buyerId, this.productId, this.name, this.price, this.saleDate, this.sold
        );
    };
};
