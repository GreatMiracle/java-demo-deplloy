package com.example.j6storeit.service;

import com.example.j6storeit.entity.Category;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
}
