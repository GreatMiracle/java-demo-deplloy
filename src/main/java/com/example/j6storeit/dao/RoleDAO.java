package com.example.j6storeit.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.j6storeit.entity.Role;

public interface RoleDAO extends JpaRepository<Role, String> {

}
