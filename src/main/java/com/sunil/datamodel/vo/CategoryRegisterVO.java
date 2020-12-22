package com.sunil.datamodel.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryRegisterVO {
    private String categoryName;

    @Override
    public String toString() {
        return String.format(
                "Category[categoryName='%s']",
                this.categoryName
        );
    };
}
