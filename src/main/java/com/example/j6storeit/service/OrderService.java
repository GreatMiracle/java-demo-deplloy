package com.example.j6storeit.service;

import com.example.j6storeit.entity.Order;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface OrderService {
    Order create(JsonNode orderData);

    Order findById(Long id);

    List<Order> findByUsername(String username);
}
