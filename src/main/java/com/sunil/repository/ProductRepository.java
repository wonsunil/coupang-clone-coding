package com.sunil.repository;

import com.sunil.datamodel.dto.ProductDTO;
import com.sunil.model.Category;
import com.sunil.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findByCategoryId(int categoryId);
};