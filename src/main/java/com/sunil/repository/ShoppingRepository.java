package com.sunil.repository;

import com.sunil.datamodel.ShoppingGroupByUserId;
import com.sunil.model.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingRepository extends JpaRepository<Shopping, Integer> {
    public List<Shopping> findByUserId(int userId);

    @Query(value = "SELECT S.PRODUCT_ID, P.NAME, SUM(? * P.PRICE) as totalPrice " +
                   "FROM SHOPPING S, PRODUCT P " +
                   "WHERE S.USER_ID = ? AND S.PRODUCT_ID = P.PRODUCT_ID " +
                   "GROUP BY S.PRODUCT_ID, P.NAME"
            , nativeQuery = true)
    public ShoppingGroupByUserId totalPrice(int amount, int userId);

    public void deleteByUserIdAndProductId(int userId, int productId);
};
