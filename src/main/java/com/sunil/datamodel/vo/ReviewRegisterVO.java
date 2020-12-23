package com.sunil.datamodel.vo;

import java.util.Date;

public class ReviewRegisterVO {
    private int reviewId;
    private int userId;
    private int productId;
    private String content;
    private float rate;
    private Date reviewDate;

    @Override
    public String toString() {
        return String.format(
                "Review[reviewId=%d, userId=%d, productId=%d, content='%s', rate='%s', reviewDate='%s']",
                this.reviewId, this.userId, this.productId, this.content, this.rate, this.reviewDate
        );
    };
};
