package com.example.webshop.controller.order;

import com.example.webshop.dto.ShoeDto;
import com.example.webshop.requestInterface.AddOrderRequest;
import com.example.webshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin("http://localhost:4200")
@AllArgsConstructor
public class OrderController {

    private final UserService userService;

    @RequestMapping(value = "/addorder", method = RequestMethod.POST)
    public ResponseEntity<String> addShoeToUser(@RequestBody AddOrderRequest request) {
        userService.addToOrder(request.getUserId(), request.getShoeId());
        return new ResponseEntity<>("Added", HttpStatus.OK);
    }

    @RequestMapping(value = "/getshoes", method = RequestMethod.GET)
    public ResponseEntity<List<ShoeDto>> getShoesByUser(@RequestParam Long id) {
        List<ShoeDto> dtos = userService.getShoesByUser(id);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
