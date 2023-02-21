package com.example.j6storeit.service.impl;

import com.example.j6storeit.dao.CategoryDAO;
import com.example.j6storeit.entity.Category;
import com.example.j6storeit.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDAO cdao;
    @Override
    public List<Category> findAll() {
        return cdao.findAll();
    }
}
