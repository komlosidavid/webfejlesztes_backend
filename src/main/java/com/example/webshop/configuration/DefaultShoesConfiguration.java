package com.example.webshop.configuration;

import com.example.webshop.entity.Shoe;
import com.example.webshop.service.ShoeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class DefaultShoesConfiguration {

    private final ShoeService shoeService;

    @PostConstruct
    public void initialize() {

        // MAN
        Shoe shoe1 = Shoe.builder()
                .brand("Nike")
                .type("Airmax")
                .color("white")
                .size("42")
                .sex("man")
                .price(24490)
                .image_url("https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/i1-51980e99-7371-46ed-9932-60dfd565ebc3/air-max-excee-cipo-8QLzJP.png")
                .build();
        Shoe shoe2 = Shoe.builder()
                .brand("Adidas")
                .type("Superstar")
                .color("white")
                .size("42")
                .sex("man")
                .price(15000)
                .image_url("https://iconic.hu/UserFiles/Product/adidas-superstar-cipo-gyerek-fu7712-1620805912.jpg")
                .build();
        Shoe shoe3 = Shoe.builder()
                .brand("Puma")
                .type("Suede")
                .color("black")
                .size("42")
                .sex("man")
                .price(20000)
                .image_url("https://s13emagst.akamaized.net/products/28441/28440380/images/res_acc7d546876e7d21739120862375dc59.jpg")
                .build();
        Shoe shoe9 = Shoe.builder()
                .brand("Pepe Jeans")
                .type(" ")
                .color("blue")
                .size("42")
                .sex("man")
                .price(17000)
                .image_url("https://www.outletexpert.hu/imgs/products/O/O1714_a-large.jpg")
                .build();
        Shoe shoe10 = Shoe.builder()
                .brand("Lacoste")
                .type(" ")
                .color("white")
                .size("42")
                .sex("man")
                .price(15500)
                .image_url("https://lac-hu.akinoncdn.com/products/2020/03/12/116327/99c31949-126d-411c-80b9-67eeb2c33a42_size600x600_cropCenter.jpg")
                .build();
        this.shoeService.uploadShoe(shoe1);
        this.shoeService.uploadShoe(shoe2);
        this.shoeService.uploadShoe(shoe3);
        this.shoeService.uploadShoe(shoe9);
        this.shoeService.uploadShoe(shoe10);

        // WOMAN
        Shoe shoe4 = Shoe.builder()
                .brand("Jimmy Choo")
                .type("Romy")
                .color("black")
                .size("38")
                .sex("woman")
                .price(19790)
                .image_url("https://cdn-images.farfetch-contents.com/11/47/39/14/11473914_e7b7fc1c-a769-4ebe-afc1-2b1bea627020_1000.jpg")
                .build();
        Shoe shoe5 = Shoe.builder()
                .brand("Inna")
                .type("CC")
                .color("pink")
                .size("36")
                .sex("woman")
                .price(6500)
                .image_url("https://keeshoes.hu/a/ale/auction_image/image1_109671.s2000/feher-noi-cipok-cc-40-pink-rozsaszin-2000x2000.jpeg?_=1640384481.67911581")
                .build();
        Shoe shoe6 = Shoe.builder()
                .brand("Bugatti")
                .type("Suede")
                .color("Pink")
                .size("38")
                .sex("woman")
                .price(17000)
                .image_url("https://assets.divatod.hu/system/cache/005/834/733/small_bugatti-fergie-eco-noi-felcipo.jpg")
                .build();
        Shoe shoe7 = Shoe.builder()
                .brand("Geox")
                .type("Suede")
                .color("White")
                .size("42")
                .sex("woman")
                .price(13540)
                .image_url("https://cipomeretek.hu/wp-content/uploads/2021/03/geox-noi-cipo.jpg")
                .build();
        Shoe shoe8 = Shoe.builder()
                .brand("Carla Ricci")
                .type("Lapos")
                .color("Bézs")
                .size("42")
                .sex("woman")
                .price(21000)
                .image_url("https://w23.wp-cache.cloud/220407/webshop.chix.hu/wp-content/uploads/2022/03/30/carla-ricci-lapos-noi-cipo-1626-152-554-beige-1.jpg")
                .build();

        this.shoeService.uploadShoe(shoe4);
        this.shoeService.uploadShoe(shoe5);
        this.shoeService.uploadShoe(shoe6);
        this.shoeService.uploadShoe(shoe7);
        this.shoeService.uploadShoe(shoe8);

        // CHILDREN
        Shoe shoe11 = Shoe.builder()
                .brand("Adidas")
                .type("Daroga")
                .color("Pink")
                .size("22")
                .sex("children")
                .price(11500)
                .image_url("https://cipomeretek.hu/wp-content/uploads/2021/02/adidas-gyerek-cipo.jpg")
                .build();
        Shoe shoe12 = Shoe.builder()
                .brand("Geox")
                .type(" ")
                .color("White black")
                .size("23")
                .sex("children")
                .price(9790)
                .image_url("https://nopwebimages.azureedge.net/nopweb/27869001_geox-b151ha-08502-c0404-white-black-a-gyerek-cipo-brendon-27869001_360.jpg")
                .build();
        Shoe shoe13 = Shoe.builder()
                .brand("Geox")
                .type(" ")
                .color("Grey")
                .size("24")
                .sex("children")
                .price(1200)
                .image_url("https://www.borgo.hu/media/mf_webp/jpg/media/catalog/product/cache/354cc39a40ce5170f5ed25c7c94a6e37/b/1/b1684a-c006201_1.webp")
                .build();
        Shoe shoe14 = Shoe.builder()
                .brand("Puma")
                .type(" ")
                .color("Pink")
                .size("23")
                .sex("children")
                .price(13500)
                .image_url("https://cipomeretek.hu/wp-content/uploads/2021/03/puma-gyerekcipo.jpg")
                .build();
        Shoe shoe15 = Shoe.builder()
                .brand("Adidas")
                .type(" ")
                .color("White")
                .size("25")
                .sex("children")
                .price(9800)
                .image_url("https://sport-felszereles.hu/wp-content/uploads/2021/09/27768501_adidas-fz0090-ftwr-white-gyerek-sportcipo-brendon-27768501_600.jpg")
                .build();

        this.shoeService.uploadShoe(shoe11);
        this.shoeService.uploadShoe(shoe12);
        this.shoeService.uploadShoe(shoe13);
        this.shoeService.uploadShoe(shoe14);
        this.shoeService.uploadShoe(shoe15);
    }
}
