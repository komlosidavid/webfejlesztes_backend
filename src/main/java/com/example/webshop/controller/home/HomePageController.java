package com.example.webshop.controller.home;

import com.example.webshop.dto.ShoeDto;
import com.example.webshop.service.ShoeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/home")
@CrossOrigin("http://localhost:4200")
@AllArgsConstructor
public class HomePageController {

    private final ShoeService shoeService;

    @RequestMapping(value = "/getallshoes", method = RequestMethod.GET)
    public ResponseEntity<List<ShoeDto>> getAllShoes() {
        return new ResponseEntity<>(shoeService.getAllShoes(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getshoe", method = RequestMethod.GET)
    public ResponseEntity<ShoeDto> getShoeById(@RequestParam Long id) {
        Optional<ShoeDto> shoe = shoeService.getShoeById(id);
        return shoe.map(shoeDto -> new ResponseEntity<>(shoeDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/getshoesbysex", method = RequestMethod.GET)
    public ResponseEntity<List<ShoeDto>> getShoesBySex(@RequestParam String sex) {
        return new ResponseEntity<>(shoeService.getShoesBySex(sex), HttpStatus.OK);
    }
}
