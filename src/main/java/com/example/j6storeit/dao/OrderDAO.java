package com.example.j6storeit.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.j6storeit.entity.Order;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE o.account.username=?1")
    List<Order> findByUsername(String username);
}
