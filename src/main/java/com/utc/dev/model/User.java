package com.utc.dev.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigInteger;

@NoArgsConstructor
@Setter
@Getter
public class User {
    private String _id;
    private String name;
    @Indexed(unique = true)
    private String username;
    private String password;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
}
