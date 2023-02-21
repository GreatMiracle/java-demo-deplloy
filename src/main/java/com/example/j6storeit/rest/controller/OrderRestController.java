package com.example.j6storeit.rest.controller;

import com.example.j6storeit.entity.Order;
import com.example.j6storeit.entity.Product;
import com.example.j6storeit.service.OrderService;
import com.example.j6storeit.service.ProductService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/rest/orders")
public class OrderRestController {
    @Autowired
    OrderService orderService;

    @PostMapping()
    public Order create(@RequestBody JsonNode orderData){
        return  orderService.create(orderData);
    }
}
