package com.sunil.datamodel.dto;

import com.sunil.model.Coupon;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class CouponDTO {
    private int couponId;
    private int userId;
    private Date issuedDate;
    private Date endDate;
    private int discountPrice;
    private int discountPercentage;
    private int used;

    public CouponDTO(Coupon coupon) {
        this.couponId = coupon.getCouponId();
        this.userId = coupon.getUserId();
        this.issuedDate = coupon.getIssuedDate();
        this.endDate = coupon.getEndDate();
        this.discountPrice = coupon.getDiscountPrice();
        this.discountPercentage = coupon.getDiscountPercentage();
        this.used = coupon.getUsed();
    };

    @Override
    public String toString() {
        return String.format(
                "CouponDTO[couponId=%d, userId=%d, issuedDate='%s', endDate='%s', discountPrice=%d, discountPercentage=%d, used = %d]",
                this.couponId, this.userId, this.issuedDate, this.endDate, this.discountPrice, this.discountPercentage, this.used
        );
    };
};
