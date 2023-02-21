package com.example.j6storeit.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.j6storeit.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {

}
