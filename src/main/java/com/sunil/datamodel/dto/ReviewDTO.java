package com.sunil.datamodel.dto;

import com.sunil.model.Review;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ReviewDTO {
    private int reviewId;
    private int userId;
    private int productId;
    private String content;
    private float rate;
    private Date reviewDate;

    public ReviewDTO(Review review) {
        this.reviewId = review.getReviewId();
        this.userId = review.getUserId();
        this.productId = review.getProductId();
        this.content = review.getContent();
        this.rate = review.getRate();
        this.reviewDate = review.getReviewDate();
    };

    @Override
    public String toString() {
        return String.format(
                "ReviewDTO[reviewId=%d, userId=%d, productId=%d, content='%s', rate='%s', reviewDate='%s']",
                this.reviewId, this.userId, this.productId, this.content, this.rate, this.reviewDate
        );
    };
};
