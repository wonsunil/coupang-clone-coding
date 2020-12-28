package com.sunil.service;

import com.sunil.datamodel.dto.UserDTO;
import com.sunil.datamodel.exception.ControllableException;
import com.sunil.datamodel.vo.UserRegisterVO;
import com.sunil.model.User;
import com.sunil.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.Collator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    };

    public UserDTO userById(int userId) throws Exception{
        Optional<User> searchedUser = this.userRepository.findById(userId);

        return new UserDTO(searchedUser.orElseThrow(() -> new ControllableException("존재하지 않는 유저 아이디입니다")));
    };

    public List<UserDTO> users() {
        return this.userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    };

    public int createUser(UserRegisterVO user) {
        User createUser = User.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .name(user.getName())
                .phone(user.getPhone())
                .imageUrl("/basic_img.png")
                .build();

        this.userRepository.save(createUser);
        this.userRepository.flush();

        return createUser.getUserId();
    };

    public void deleteUser(int userId) {
        this.userRepository.deleteById(userId);
    };

    public void initializeUsers() {
        User user1 = User.builder()
                .email("email@email.com")
                .password("1234")
                .name("example")
                .phone("01012345678")
                .imageUrl("/basic_img.png")
                .build();

        User user2 = User.builder()
                .email("example@naver.com")
                .password("12345")
                .name("mr. sample")
                .phone("01087654321")
                .imageUrl("/basic_img.png")
                .build();

        User user3 = User.builder()
                .email("test@gmail.com")
                .password("test")
                .name("mr. test")
                .phone("01015978426")
                .imageUrl("/basic_img.png")
                .build();

        this.userRepository.save(user1);
        this.userRepository.save(user2);
        this.userRepository.save(user3);

        this.userRepository.flush();
    };
};
