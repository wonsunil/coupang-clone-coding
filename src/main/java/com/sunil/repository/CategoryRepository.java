package com.sunil.repository;

import com.sunil.datamodel.ProductsByCategoryId;
import com.sunil.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value =
            "SELECT PRODUCT_ID as productId" +
                    "FROM PRODUCT WHERE CATEGORY_ID = ?1",
            nativeQuery = true)
    public List<ProductsByCategoryId> productsByCategoryId(int categoryId);
};
