package com.example.j6storeit.service.impl;

import com.example.j6storeit.dao.AccountDAO;
import com.example.j6storeit.dao.AuthorityDAO;
import com.example.j6storeit.entity.Account;
import com.example.j6storeit.entity.Authority;
import com.example.j6storeit.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    AccountDAO adao;
    @Autowired
    AuthorityDAO dao;
    @Override
    public List<Authority> findAuthoritiesOfAdministrator() {
        List<Account> accounts=adao.getAdministrators();
        System.out.println("chay qua kiem duyet");
        return dao.authoritiesOf(accounts);
    }

    @Override
    public List<Authority> findAll() {
        return dao.findAll();
    }

    @Override
    public Authority create(Authority auth) {
        return dao.save(auth);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
