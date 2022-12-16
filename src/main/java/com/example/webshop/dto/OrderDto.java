package com.example.webshop.dto;

import com.example.webshop.entity.Shoe;
import com.example.webshop.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Setter
@Getter
public class OrderDto {

    private Long id;
    private List<ShoeDto> shoes;
    private UserDto user;
    private Instant created;
}
