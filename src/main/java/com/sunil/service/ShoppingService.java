package com.sunil.service;

import com.sunil.datamodel.dto.ShoppingDTO;
import com.sunil.datamodel.vo.ShoppingRegisterVO;
import com.sunil.model.Shopping;
import com.sunil.repository.ProductRepository;
import com.sunil.repository.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ShoppingService {
    private final ShoppingRepository shoppingRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ShoppingService(ShoppingRepository shoppingRepository, ProductRepository productRepository) {
        this.shoppingRepository = shoppingRepository;
        this.productRepository = productRepository;
    };

    public List<ShoppingDTO> shoppingByUserId(int userId) {
        return this.shoppingRepository.findByUserId(userId).stream().map(ShoppingDTO::new).collect(Collectors.toList());
    };

    public int getTotalPrice(int userId) {
        List<ShoppingDTO> list = this.shoppingRepository.findByUserId(userId)
                .stream()
                .map(ShoppingDTO::new)
                .collect(Collectors.toList());

        int total = 0;

        for(ShoppingDTO product : list) {
            int price = this.productRepository.findById(product.getProductId()).get().getPrice();

            total += (price * product.getAmount());
        }

        return total;
    };

    public int addProductShoppingList(ShoppingRegisterVO shopping) {
        Shopping product = Shopping.builder()
                .userId(shopping.getUserId())
                .amount(shopping.getAmount())
                .productId(shopping.getProductId())
                .build();

        this.shoppingRepository.save(product);
        this.shoppingRepository.flush();

        return product.getBasketId();
    };

    public void deleteProductFromShoppingList(int userId, int productId) {
        int basketId = this.shoppingRepository.findShoppingByUserIdAndProductId(userId, productId).getBasketId();

        this.shoppingRepository.deleteById(basketId);
    };
}
