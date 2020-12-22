package com.sunil.datamodel.dto;

import com.sunil.model.User;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    private int userId;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String imageUrl;

    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.name = user.getName();
        this.phone = user.getPhone();
        this.imageUrl = user.getImageUrl();
    };

    @Override
    public String toString() {
        return String.format(
                "UserDTO[userId=%d, email='%s', name='%s', phone='%s', image='%s']",
                this.userId, this.email, this.name, this.phone, this.imageUrl
        );
    };
};
