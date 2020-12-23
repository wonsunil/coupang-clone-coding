package com.sunil.datamodel.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ReviewRegisterVO {
    private int userId;
    private int productId;
    private String content;
    private float rate;
    private Date reviewDate;

    @Override
    public String toString() {
        return String.format(
                "Review[userId=%d, productId=%d, content='%s', rate='%s', reviewDate='%s']",
                this.userId, this.productId, this.content, this.rate, this.reviewDate
        );
    };
};
