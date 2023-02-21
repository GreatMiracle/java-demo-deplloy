package com.example.j6storeit.service;

import java.util.List;
import java.util.Optional;

import com.example.j6storeit.entity.Product;

public interface ProductService {
	
	List<Product> findAll();
	Product findById(Integer id);

	List<Product> findByCateId(String cid);

    Product create(Product product);

	Product update(Product product);

    void delete(Integer id);
}
