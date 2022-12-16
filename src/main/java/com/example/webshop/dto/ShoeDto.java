package com.example.webshop.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ShoeDto {

    private Long id;
    private String brand;
    private String type;
    private String size;
    private String color;
    private String image_url;
    private String sex;
    private int price;
}
