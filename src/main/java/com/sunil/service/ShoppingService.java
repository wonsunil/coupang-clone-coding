package com.sunil.service;

import com.sunil.datamodel.ShoppingGroupByUserId;
import com.sunil.datamodel.ShoppingTotalPrice;
import com.sunil.datamodel.dto.ShoppingDTO;
import com.sunil.datamodel.vo.ShoppingRegisterVO;
import com.sunil.model.Shopping;
import com.sunil.repository.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ShoppingService {
    private final ShoppingRepository shoppingRepository;

    @Autowired
    public ShoppingService(ShoppingRepository shoppingRepository) {
        this.shoppingRepository = shoppingRepository;
    };

    public List<ShoppingDTO> shoppingByUserId(int userId) {
        return this.shoppingRepository.findByUserId(userId).stream().map(ShoppingDTO::new).collect(Collectors.toList());
    };

    public int getTotalPrice(int userId) {
        ShoppingGroupByUserId groupData = this.shoppingRepository.totalPrice(userId);
        ShoppingTotalPrice totalPrice = new ShoppingTotalPrice(groupData);

        return totalPrice.getTotalPrice();
    };

    public String addProductShoppingList(ShoppingRegisterVO shopping) {
        Shopping product = Shopping.builder()
                .userId(shopping.getUserId())
                .amount(shopping.getAmount())
                .productId(shopping.getProductId())
                .build();

        this.shoppingRepository.save(product);
        this.shoppingRepository.flush();

        return "성공적으로 추가되었습니다!";
    };

    public void deleteProductFromShoppingList(int userId, int productId) {
        this.shoppingRepository.deleteByUserIdAndProductId(userId, productId);
    };
}
