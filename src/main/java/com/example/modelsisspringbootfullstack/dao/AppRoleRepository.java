package com.example.modelsisspringbootfullstack.dao;


import com.example.modelsisspringbootfullstack.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    public AppRole findByRoleName(String roleName);
}
