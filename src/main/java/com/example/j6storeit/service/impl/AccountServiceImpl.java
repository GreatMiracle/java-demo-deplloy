package com.example.j6storeit.service.impl;

import com.example.j6storeit.dao.AccountDAO;
import com.example.j6storeit.entity.Account;
import com.example.j6storeit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDAO adao;

    @Override
    public Account findById(String username) {
        return adao.findById(username).get();
    }

    @Override
    public List<Account> findAll() {
        return adao.findAll();
    }

    @Override
    public List<Account> getAdministrators() {
        return adao.getAdministrators();
    }
}
