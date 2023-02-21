package com.example.j6storeit.rest.controller;

import com.example.j6storeit.entity.Role;
import com.example.j6storeit.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest/roles")
public class RoleRestController {
    @Autowired
    RoleService roleService;

    @GetMapping
    public List<Role> getAll(){

        return roleService.findAll();

    }
}
