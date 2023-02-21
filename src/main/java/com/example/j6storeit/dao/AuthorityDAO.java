package com.example.j6storeit.dao;
import com.example.j6storeit.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.j6storeit.entity.Authority;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorityDAO extends JpaRepository<Authority, Integer> {
    @Query("SELECT DISTINCT a FROM Authority a WHERE a.account IN ?1")
    List<Authority> authoritiesOf(List<Account> accounts);
}
