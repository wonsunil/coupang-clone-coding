package com.sunil.datamodel.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRegisterVO {
    private int userId;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String imageUrl;

    @Override
    public String toString() {
        return String.format(
                "UserRegisterVO[userId=%d, email='%s', name='%s', phone='%s', image='%s']",
                this.userId, this.email, this.name, this.phone, this.imageUrl
        );
    };
};
