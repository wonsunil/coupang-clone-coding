package com.sunil.route;

import com.sunil.datamodel.dto.UserDTO;
import com.sunil.datamodel.vo.UserRegisterVO;
import com.sunil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRoute {
    private final UserService userService;

    @Autowired
    public UserRoute(UserService userService) {
        this.userService = userService;
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
};
