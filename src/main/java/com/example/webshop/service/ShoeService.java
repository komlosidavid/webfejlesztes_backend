package com.example.webshop.service;

import com.example.webshop.dto.ShoeDto;
import com.example.webshop.entity.Shoe;

import java.util.List;
import java.util.Optional;

public interface ShoeService {

    void uploadShoe(Shoe shoe);

    List<ShoeDto> getAllShoes();

    void delete(Long id);

    Optional<ShoeDto> getShoeById(Long id);

    List<ShoeDto> getShoesBySex(String sex);

    void updateShoe(ShoeDto shoeDto);
}

