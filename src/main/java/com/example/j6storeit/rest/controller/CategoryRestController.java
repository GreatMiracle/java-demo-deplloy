package com.example.j6storeit.rest.controller;

import com.example.j6storeit.entity.Category;
import com.example.j6storeit.entity.Product;
import com.example.j6storeit.service.CategoryService;
import com.example.j6storeit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/rest/categories")
public class CategoryRestController {
    @Autowired
    CategoryService categoryService;

    @GetMapping()
    public List<Category> getAll(){
        return categoryService.findAll();
    }
}
