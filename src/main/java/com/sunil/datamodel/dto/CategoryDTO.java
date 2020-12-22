package com.sunil.datamodel.dto;

import com.sunil.model.Category;

public class CategoryDTO {
    private String categoryName;

    public CategoryDTO(Category category) {
        this.categoryName = category.getCategoryName();
    };

    @Override
    public String toString() {
        return String.format(
                "Category[categoryName='%s']",
                this.categoryName
        );
    };
};
