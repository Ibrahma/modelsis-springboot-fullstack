package com.example.modelsisspringbootfullstack.dao;

import com.example.modelsisspringbootfullstack.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    public AppUser findByUsername(String username);
}
