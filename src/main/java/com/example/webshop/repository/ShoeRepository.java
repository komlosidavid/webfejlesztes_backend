package com.example.webshop.repository;

import com.example.webshop.entity.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoeRepository extends JpaRepository<Shoe, Long> {

    List<Shoe> findAllBySex(String sex);
}
