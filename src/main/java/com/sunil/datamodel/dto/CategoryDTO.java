package com.sunil.datamodel.dto;

public class CategoryDTO {
    private String categoryName;

    @Override
    public String toString() {
        return String.format(
                "Category[categoryName='%s']",
                this.categoryName
        );
    };
};
