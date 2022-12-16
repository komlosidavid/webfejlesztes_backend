package com.example.webshop.controller.admin;

import com.example.webshop.dto.ShoeDto;
import com.example.webshop.dto.UserDto;
import com.example.webshop.entity.Shoe;
import com.example.webshop.requestInterface.ShoeUploadRequest;
import com.example.webshop.requestInterface.UpdateShoeRequest;
import com.example.webshop.service.ShoeService;
import com.example.webshop.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("http://localhost:4200")
@AllArgsConstructor
public class AdminController {

    private final ShoeService shoeService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @RequestMapping(value = "/createshoe", method = RequestMethod.POST)
    public ResponseEntity<ShoeDto> uploadShoe(@RequestBody ShoeUploadRequest request) {
        Shoe shoe = Shoe.builder()
                .brand(request.getBrand())
                .type(request.getType())
                .size(request.getSize())
                .color(request.getColor())
                .sex(request.getSex())
                .price(request.getPrice())
                .image_url(request.getImage_url())
                .build();
        ShoeDto shoeDto = modelMapper.map(shoe, ShoeDto.class);
        shoeService.uploadShoe(shoe);
        return new ResponseEntity<>(shoeDto, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/updateshoe", method = RequestMethod.PUT)
    public ResponseEntity<ShoeDto> updateShoe(@RequestBody UpdateShoeRequest request) {
        Optional<ShoeDto> shoe = shoeService.getShoeById(request.getId());
        if (shoe.isPresent()) {
            ShoeDto dto = ShoeDto.builder()
                    .id(request.getId())
                    .brand(request.getBrand())
                    .type(request.getType())
                    .color(request.getColor())
                    .size(request.getSize())
                    .price(request.getPrice())
                    .image_url(request.getImage_url())
                    .build();
            shoeService.updateShoe(dto);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/getallaccounts", method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> getAllAccounts() {
        return new ResponseEntity<>(userService.getAllAccounts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteshoe", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteShoe(@RequestParam Long id) {
        this.shoeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
