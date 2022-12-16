package com.example.webshop.requestInterface;

import lombok.Getter;

@Getter
public class ShoeUploadRequest {

    private String brand;
    private String type;
    private String size;
    private String color;
    private String sex;
    private int price;
    private String image_url;
}
