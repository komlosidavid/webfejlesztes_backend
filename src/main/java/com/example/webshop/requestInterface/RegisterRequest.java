package com.example.webshop.requestInterface;

import lombok.Getter;

@Getter
public class RegisterRequest {
    private String username;
    private String email;
    private String name;
    private String password;
}
