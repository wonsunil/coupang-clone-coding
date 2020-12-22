package com.sunil.springshoppigmall.model;

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
    private String name;

    @Column
    private int price;

    @Column
    private Date saleDate;

    @Column
    private int sold;

    @Builder
    public Sale(int buyerId, int productId, String name, int price, Date saleDate, int sold) {
        this.buyerId = buyerId;
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.saleDate = saleDate;
        this.sold = sold;
    };

    @Override
    public String toString() {
        return String.format(
                "Sale[saleId=%d, buryerId=%d, productId=%d, name='%s', price=%d, saleDate='%s', sold=%d]",
                this.saleId, this.buyerId, this.productId, this.name, this.price, this.saleDate, this.sold
        );
    };
};
