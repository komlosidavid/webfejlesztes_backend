package com.example.webshop.controller.auth;

import com.example.webshop.dto.AuthResponseDto;
import com.example.webshop.dto.UserDto;
import com.example.webshop.entity.Role;
import com.example.webshop.entity.User;
import com.example.webshop.requestInterface.LoginRequest;
import com.example.webshop.requestInterface.RegisterRequest;
import com.example.webshop.security.JwtTokenProvider;
import com.example.webshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:4200")
@AllArgsConstructor
public class AuthController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider provider;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @Transactional
    public ResponseEntity<AuthResponseDto> register(@RequestBody RegisterRequest request) {
        Optional<UserDto> userDtoOptional = userService.checkIfUserExists(
                request.getUsername(),
                request.getEmail()
        );
        if (userDtoOptional.isEmpty()) {
            User user = User.builder()
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .name(request.getName())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.USER)
                    .build();
            //Order order = new Order(null, user.getUsername(), new ArrayList<>());
            userService.register(user);
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(),
                            request.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = provider.generateToken(authentication);
            return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.FOUND);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),
                        request.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = provider.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
    }

    @RequestMapping(value = "/getuserbytoken", method = RequestMethod.GET)
    public ResponseEntity<UserDto> getUserByToken(@RequestParam String token) {
        String username = provider.getUsernameFromToken(token);
        Optional<UserDto> dto = userService.getUserByUsername(username);
        return dto.map(userDto -> new ResponseEntity<>(userDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/checktoken", method = RequestMethod.POST)
    public ResponseEntity<Boolean> checkIfTokenIsValid(@RequestBody String token) {
        if (provider.validateToken(token)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
