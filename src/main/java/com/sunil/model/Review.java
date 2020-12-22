package com.sunil.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private int productId;

    @Column
    private String content;

    @Column
    private float rate;

    @Column
    private Date reviewDate;

    @Builder
    public Review(int userId, int productId, String content, float rate, Date reviewDate) {
        this.userId = userId;
        this.productId = productId;
        this.content = content;
        this.rate = rate;
        this.reviewDate = reviewDate;
    };

    @Override
    public String toString() {
        return String.format(
                "Review[reviewId=%d, userId=%d, productId=%d, content='%s', rate='%s', reviewDate='%s']",
                this.reviewId, this.userId, this.productId, this.content, this.rate, this.reviewDate
        );
    };
};
