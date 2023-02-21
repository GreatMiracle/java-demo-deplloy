package com.example.j6storeit.service.impl;

import com.example.j6storeit.dao.RoleDAO;
import com.example.j6storeit.entity.Role;
import com.example.j6storeit.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDAO dao;
    @Override
    public List<Role> findAll() {
        return dao.findAll();
    }
}
