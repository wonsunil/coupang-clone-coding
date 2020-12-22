package com.sunil.springshoppigmall.repository;

import com.sunil.springshoppigmall.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

};
