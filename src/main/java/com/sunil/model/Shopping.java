package com.sunil.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Shopping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int basketId;

    @Column
    private int userId;

    @Column
    private int amount;

    @JoinColumn(name = "productId")
    private int productId;

    @Builder
    public Shopping(int userId, int amount, int productId) {
        this.userId = userId;
        this.amount = amount;
        this.productId = productId;
    };

    @Override
    public String toString() {
        return String.format(
                "Shopping[userId=%d, amount=%d, productId=%d]",
                this.userId, this.amount, this.productId
        );
    };
};
