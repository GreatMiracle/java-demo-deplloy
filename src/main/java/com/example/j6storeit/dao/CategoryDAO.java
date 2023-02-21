package com.example.j6storeit.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.j6storeit.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, String> {

}
