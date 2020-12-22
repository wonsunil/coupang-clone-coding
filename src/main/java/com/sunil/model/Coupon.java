package com.sunil.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int couponId;

    @Column
    private int userId;

    @Column
    private Date issuedDate;

    @Column
    private Date endDate;

    @Column
    private int discountPrice;

    @Column
    private int discountPercentage;

    @Column(length = 2, nullable = false)
    private int used;

    @Builder
    public Coupon(int userId, Date issuedDate, Date endDate, int discountPrice, int discountPercentage, int used) {
        this.userId = userId;
        this.issuedDate = issuedDate;
        this.endDate = endDate;
        this.discountPrice = discountPrice;
        this.discountPercentage = discountPercentage;
        this.used = used;
    };

    @Override
    public String toString() {
        return String.format(
                "Coupon[couponId=%d, userId=%d, issuedDate='%s', endDate='%s', discountPrice=%d, discountPercentage=%d, used = %d]",
                this.couponId, this.userId, this.issuedDate, this.endDate, this.discountPrice, this.discountPercentage, this.used
        );
    };
};
