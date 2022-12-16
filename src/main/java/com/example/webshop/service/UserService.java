package com.example.webshop.service;

import com.example.webshop.dto.ShoeDto;
import com.example.webshop.dto.UserDto;
import com.example.webshop.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    Optional<UserDto> checkIfUserExists(String username, String email);

    void register(User user);

    Optional<UserDto> getUserByUsername(String username);

    void addToOrder(Long userId, Long shoeId);

    List<UserDto> getAllAccounts();

    List<ShoeDto> getShoesByUser(Long id);
}
