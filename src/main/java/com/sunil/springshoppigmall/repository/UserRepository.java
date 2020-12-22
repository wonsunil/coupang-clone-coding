package com.sunil.springshoppigmall.repository;

import com.sunil.springshoppigmall.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

};