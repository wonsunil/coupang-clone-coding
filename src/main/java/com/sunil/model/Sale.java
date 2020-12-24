package com.sunil.model;

import com.sunil.datamodel.enumModel.SaleStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int saleId;

    @Column
    private int buyerId;

    @Column
    private int productId;

    @Column
    private int amount;

    @Column
    private int price;

    @Column
    private String saleDate;

    @Column
    private SaleStatus sold;

    @Builder
    public Sale(int buyerId, int productId, int amount, int price, String saleDate, SaleStatus sold) {
        this.buyerId = buyerId;
        this.productId = productId;
        this.amount = amount;
        this.price = price;
        this.saleDate = saleDate;
        this.sold = sold;
    };

    @Override
    public String toString() {
        return String.format(
                "Sale[saleId=%d, buryerId=%d, productId=%d, amount=%d, price=%d, saleDate='%s', sold=%d]",
                this.saleId, this.buyerId, this.productId, this.amount, this.price, this.saleDate, this.sold
        );
    };
};
