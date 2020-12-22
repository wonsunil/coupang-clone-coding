package com.sunil.datamodel.dto;

import com.sunil.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryDTO {
    private int categoryId;
    private String categoryName;

    public CategoryDTO(Category category) {
        this.categoryId = category.getCategoryId();
        this.categoryName = category.getCategoryName();
    };

    @Override
    public String toString() {
        return String.format(
                "Category[categoryId=%d, categoryName='%s']",
                this.categoryId, this.categoryName
        );
    };
};
