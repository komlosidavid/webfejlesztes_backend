package com.example.webshop.service.impl;

import com.example.webshop.dto.ShoeDto;
import com.example.webshop.entity.Shoe;
import com.example.webshop.repository.ShoeRepository;
import com.example.webshop.service.ShoeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShoeServiceImpl implements ShoeService {

    private final ShoeRepository shoeRepository;
    private final ModelMapper modelMapper;

    private final List<String> sexs = List.of("man", "woman", "children");

    @Override
    public Optional<ShoeDto> getShoeById(Long id) {
        Optional<Shoe> shoe = shoeRepository.findById(id);
        if (shoe.isPresent()) {
            ShoeDto dto = modelMapper.map(shoe.get(), ShoeDto.class);
            return Optional.of(dto);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void uploadShoe(Shoe shoe) {
        if (!sexs.contains(shoe.getSex())) {
            throw new IllegalArgumentException("Not allowed sex type!");
        }
        shoeRepository.save(shoe);
    }

    @Override
    public List<ShoeDto> getAllShoes() {
        List<Shoe> shoes =  shoeRepository.findAll();
        return shoes.stream()
                .map(shoe -> modelMapper.map(shoe, ShoeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShoeDto> getShoesBySex(String sex) {
        List<Shoe> shoes = shoeRepository.findAllBySex(sex);
        return shoes.stream()
                .map(shoe -> modelMapper.map(shoe, ShoeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void updateShoe(ShoeDto shoeDto) {
        Optional<Shoe> shoeOptional = shoeRepository.findById(shoeDto.getId());
        if (shoeOptional.isPresent()) {
            Shoe shoe = shoeOptional.get();
            shoe.setBrand(shoeDto.getBrand());
            shoe.setType(shoeDto.getType());
            shoe.setSize(shoeDto.getSize());
            shoe.setColor(shoeDto.getColor());
            shoe.setPrice(shoeDto.getPrice());
            shoe.setImage_url(shoeDto.getImage_url());
            shoeRepository.save(shoe);
        } else {
            throw new IllegalArgumentException("404");
        }
    }

    @Override
    public void delete(Long id) {
        this.shoeRepository.deleteById(id);
    }
}
