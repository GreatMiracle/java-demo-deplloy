package com.example.j6storeit.service.impl;

import com.example.j6storeit.dao.OrderDAO;
import com.example.j6storeit.dao.OrderDetailDAO;
import com.example.j6storeit.entity.Order;
import com.example.j6storeit.entity.OrderDetail;
import com.example.j6storeit.service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDAO dao;
    @Autowired
    OrderDetailDAO ddao;

    @Override
    public Order create(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.convertValue(orderData,Order.class);
        System.out.println( "đây là username"+order.getAccount().getUsername());
        dao.save(order);
        TypeReference<List<OrderDetail>> type=new TypeReference<List<OrderDetail>>(){};
        List<OrderDetail> details=mapper.convertValue(orderData.get("orderDetails"),type)
                .stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
        ddao.saveAll(details);
        return order;
    }

    @Override
    public Order findById(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Order> findByUsername(String username) {
        return dao.findByUsername(username);
    }
}
