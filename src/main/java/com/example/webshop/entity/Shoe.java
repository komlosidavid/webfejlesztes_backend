package com.example.webshop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;


@Entity
@Table(name = "shoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Shoe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    private String brand;
    private String type;
    private String size;
    private String color;
    private String image_url;
    private String sex;
    private int price;
    @Builder.Default
    private Instant created = new Date().toInstant();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shoe shoe = (Shoe) o;

        return id.equals(shoe.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
