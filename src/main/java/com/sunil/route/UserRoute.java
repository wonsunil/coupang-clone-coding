package com.sunil.route;

import com.sunil.datamodel.dto.ShoppingDTO;
import com.sunil.datamodel.dto.UserDTO;
import com.sunil.datamodel.vo.ShoppingRegisterVO;
import com.sunil.datamodel.vo.UserRegisterVO;
import com.sunil.service.ShoppingService;
import com.sunil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRoute {
    private final UserService userService;
    private final ShoppingService shoppingService;

    @Autowired
    public UserRoute(UserService userService, ShoppingService shoppingService) {
        this.userService = userService;
        this.shoppingService = shoppingService;
    };

    @GetMapping("/initialize")
    public void initialize() {
        this.userService.initializeUsers();
    };

    @GetMapping("")
    @ResponseBody
    public List<UserDTO> getUsers() {
        return this.userService.users();
    };

    @GetMapping("/{userId}")
    @ResponseBody
    public UserDTO user(@PathVariable(value = "userId") String userId) throws Exception {
        return this.userService.userById(Integer.parseInt(userId));
    };

    @PostMapping("")
    public int createUser(UserRegisterVO user) {
        return this.userService.createUser(user);
    };

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable(value = "userId") String userId) {
        this.userService.deleteUser(Integer.parseInt(userId));
    };

    @GetMapping("/{userId}/shopping-basket")
    public List<ShoppingDTO> getShoppingListByUserId(@PathVariable(value = "userId") String userId) {
        return this.shoppingService.shoppingByUserId(Integer.parseInt(userId));
    };

    @GetMapping("/{userId}/shopping-basket/total")
    public int getShoppingTotalPriceByUserId(@PathVariable(value = "userId") String userId) {
        return this.shoppingService.getTotalPrice(Integer.parseInt(userId));
    };

    @PostMapping("/{userId}/shopping-basket")
    public void addProductInShoppingList(@PathVariable(value = "userId") String userId,
                                         @RequestParam("productId") String productId,
                                         @RequestParam("amount") int amount
    ) {
        this.shoppingService.addProductShoppingList(new ShoppingRegisterVO(Integer.parseInt(userId), amount, Integer.parseInt(productId)));
    };
};
