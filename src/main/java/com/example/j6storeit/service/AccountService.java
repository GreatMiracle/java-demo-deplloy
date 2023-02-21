package com.example.j6storeit.service;

import com.example.j6storeit.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {
    Account findById(String username);

    List<Account> findAll();

    List<Account> getAdministrators();
}
