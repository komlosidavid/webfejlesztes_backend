package com.example.webshop.dto;

import com.example.webshop.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String username;
    private String email;
    private String name;
    private Role role;
    private Instant created;
}
