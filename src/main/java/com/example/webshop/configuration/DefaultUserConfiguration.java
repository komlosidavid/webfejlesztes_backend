package com.example.webshop.configuration;

import com.example.webshop.entity.Role;
import com.example.webshop.entity.User;
import com.example.webshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class DefaultUserConfiguration {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    public void initialize() {
        User userAdmin = User.builder()
                .name("admin")
                .username("admin")
                .email("admin")
                .password(passwordEncoder.encode("12345678"))
                .role(Role.ADMIN)
                .build();
        User userTest = User.builder()
                .name("test")
                .username("test")
                .email("test")
                .password(passwordEncoder.encode("12345678"))
                .role(Role.USER)
                .build();
        userService.register(userAdmin);
        userService.register(userTest);
    }
}
