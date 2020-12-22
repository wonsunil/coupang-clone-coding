package com.sunil.datamodel.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRegisterVO {
    private String email;
    private String password;
    private String name;
    private String phone;
    private String imageUrl;

    @Override
    public String toString() {
        return String.format(
                "UserRegisterVO[email='%s', name='%s', phone='%s', image='%s']",
                this.email, this.name, this.phone, this.imageUrl
        );
    };
};
