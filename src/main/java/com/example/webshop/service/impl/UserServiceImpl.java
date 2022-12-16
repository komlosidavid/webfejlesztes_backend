package com.example.webshop.service.impl;

import com.example.webshop.dto.ShoeDto;
import com.example.webshop.dto.UserDto;
import com.example.webshop.entity.Shoe;
import com.example.webshop.entity.User;
import com.example.webshop.repository.ShoeRepository;
import com.example.webshop.repository.UserRepository;
import com.example.webshop.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ShoeRepository shoeRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<UserDto> checkIfUserExists(String username, String email) {
        return userRepository.checkIfUserExists(username, email);
    }



    @Override
    public Optional<UserDto> getUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            UserDto dto = modelMapper.map(user.get(), UserDto.class);
            return Optional.of(dto);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<ShoeDto> getShoesByUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get().getShoes().stream()
                    .map(shoe -> modelMapper.map(shoe, ShoeDto.class))
                    .collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("404");
        }
    }

    @Override
    public List<UserDto> getAllAccounts() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void register(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void addToOrder(Long userId, Long shoeId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Shoe> shoe = shoeRepository.findById(shoeId);

        if (user.isPresent() && shoe.isPresent()) {
            user.get().getShoes().add(shoe.get());
        } else {
            throw new IllegalArgumentException("404");
        }
    }
}
