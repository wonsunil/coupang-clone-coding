package com.sunil.springshoppigmall.repository;

import com.sunil.springshoppigmall.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

};
