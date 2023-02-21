package com.example.j6storeit.service;

import com.example.j6storeit.entity.Authority;

import java.util.List;

public interface AuthorityService {
    List<Authority> findAuthoritiesOfAdministrator();

    List<Authority> findAll();

    Authority create(Authority auth);

    void delete(Integer id);
}
