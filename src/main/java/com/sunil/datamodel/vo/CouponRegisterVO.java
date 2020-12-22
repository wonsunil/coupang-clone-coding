package com.sunil.datamodel.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class CouponRegisterVO {
    private int userId;
    private Date issuedDate;
    private Date endDate;
    private int discountPrice;
    private int discountPercentage;
    private int used;

    @Override
    public String toString() {
        return String.format(
                "CouponRegisterVO[userId=%d, issuedDate='%s', endDate='%s', discountPrice=%d, discountPercentage=%d, used = %d]",
                this.userId, this.issuedDate, this.endDate, this.discountPrice, this.discountPercentage, this.used
        );
    };
};
