package com.sunil.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column
    private String categoryName;

    @Builder
    public Category(String categoryName) {
        this.categoryName = categoryName;
    };

    @Override
    public String toString() {
        return String.format(
                "Category[categoryId=%d, categoryName='%s']",
                this.categoryId, this.categoryName
        );
    };
};
