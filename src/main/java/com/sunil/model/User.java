package com.sunil.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private String imageUrl;

    @Builder
    public User(String email, String password, String name, String phone, String imageUrl) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.imageUrl = imageUrl;
    };

    @Override
    public String toString() {
        return String.format(
            "User[userId=%d, email='%s', name='%s', phone='%s', image='%s']",
            this.userId, this.email, this.name, this.phone, this.imageUrl
        );
    };
};
