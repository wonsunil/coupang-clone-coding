package com.sunil.repository;

import com.sunil.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findByCategoryId(int categoryId);

    @Query(value =
            "SELECT PRODUCT_ID, SUM(RATE) as totalRate " +
                    "FROM REVIEW WHERE PRODUCT_ID = ? GROUP BY PRODUCT_ID",
            nativeQuery = true)
    public Float getRateByProductId(int productId);
};