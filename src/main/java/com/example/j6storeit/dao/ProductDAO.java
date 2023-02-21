package com.example.j6storeit.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.j6storeit.entity.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.category.id=?1")
    List<Product> findByCateId(String cid);
}
