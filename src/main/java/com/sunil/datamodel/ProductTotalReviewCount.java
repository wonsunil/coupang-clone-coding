package com.sunil.datamodel;

import lombok.Getter;

@Getter
public class ProductTotalReviewCount {
    int productId;
    int totalReviewCount;

    public ProductTotalReviewCount(ReviewGroupByProductId group) {
        this.productId = group.getProductId();
        this.totalReviewCount = group.getTotalReviewCount();
    };

    @Override
    public String toString() {
        return String.format(
            "ProductTotalReviewCount[productId=%d, totalReviewCount=%d]",
                this.productId, this.totalReviewCount
        );
    };
}
