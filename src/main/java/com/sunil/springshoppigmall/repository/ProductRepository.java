package com.sunil.springshoppigmall.repository;

import com.sunil.springshoppigmall.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

};