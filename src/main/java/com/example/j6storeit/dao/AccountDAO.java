package com.example.j6storeit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.j6storeit.entity.Account;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountDAO extends JpaRepository<Account, String> {
    @Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN ('DIRE','STAF')")
    List<Account> getAdministrators();
}
