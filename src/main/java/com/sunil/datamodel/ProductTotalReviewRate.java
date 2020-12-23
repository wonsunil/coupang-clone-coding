package com.sunil.datamodel;

import lombok.Getter;

@Getter
public class ProductTotalReviewRate {
    float totalRate;

    public ProductTotalReviewRate(ReviewGroupByProductId group) {
        this.totalRate = group.getTotalRate();
    };
};
