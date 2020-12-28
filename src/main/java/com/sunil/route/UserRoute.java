package com.sunil.route;

import com.sunil.datamodel.dto.ShoppingDTO;
import com.sunil.datamodel.dto.UserDTO;
import com.sunil.datamodel.vo.ShoppingRegisterVO;
import com.sunil.datamodel.vo.UserRegisterVO;
import com.sunil.service.ShoppingService;
import com.sunil.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "유저 기초 생성")
    @GetMapping("/initialize")
    public void initialize() {
        this.userService.initializeUsers();
    };

    @ApiOperation(value = "유저 전체 조회")
    @GetMapping("")
    @ResponseBody
    public List<UserDTO> getUsers() {
        return this.userService.users();
    };

    @ApiOperation(value = "유저 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "유저 ID", required = true, dataType = "string")
    })
    @GetMapping("/{userId}")
    @ResponseBody
    public UserDTO user(@PathVariable(value = "userId") String userId) throws Exception {
        return this.userService.userById(Integer.parseInt(userId));
    };

    @ApiOperation(value = "유저 생성")
    @PostMapping("")
    public int createUser(UserRegisterVO user) {
        return this.userService.createUser(user);
    };

    @ApiOperation(value = "유저 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "유저 ID", required = true, dataType = "string")
    })
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable(value = "userId") String userId) {
        this.userService.deleteUser(Integer.parseInt(userId));
    };

    @ApiOperation(value = "장바구니 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "유저 ID", required = true, dataType = "string")
    })
    @GetMapping("/{userId}/shopping-basket")
    public List<ShoppingDTO> getShoppingListByUserId(@PathVariable(value = "userId") String userId) {
        return this.shoppingService.shoppingByUserId(Integer.parseInt(userId));
    };

    @ApiOperation(value = "장바구니 총 결제금액 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "유저 ID", required = true, dataType = "string")
    })
    @GetMapping("/{userId}/shopping-basket/total")
    public int getShoppingTotalPriceByUserId(@PathVariable(value = "userId") String userId) {
        return this.shoppingService.getTotalPrice(Integer.parseInt(userId));
    };

    @ApiOperation(value = "장바구니에 추가")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "유저 ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "productId", value = "상품 ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "amount", value = "상품 개수", required = true, dataType = "int")
    })
    @PostMapping("/{userId}/shopping-basket")
    public void addProductInShoppingList(@PathVariable(value = "userId") String userId,
                                         @RequestParam("productId") String productId,
                                         @RequestParam("amount") int amount
    ) {
        this.shoppingService.addProductShoppingList(new ShoppingRegisterVO(Integer.parseInt(userId), amount, Integer.parseInt(productId)));
    };

    @ApiOperation(value = "장바구니에서 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "유저 ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "productId", value = "상품 ID", required = true, dataType = "string"),
    })
    @DeleteMapping("/{userId}/shopping-basket/{productId}")
    public void deleteProductFromShoppingList(@PathVariable(value = "userId") String userId,
                                              @PathVariable(value = "productId") String productId
    ) {
        this.shoppingService.deleteProductFromShoppingList(Integer.parseInt(userId), Integer.parseInt(productId));
    };
};