package com.example.modelsisspringbootfullstack.services;


import com.example.modelsisspringbootfullstack.dto.AppUserDto;
import com.example.modelsisspringbootfullstack.entities.AppRole;
import com.example.modelsisspringbootfullstack.entities.AppUser;

public interface AccountService {
    public AppUser saveUser(AppUserDto appUserDto);
    public AppRole save(AppRole role);
    public AppUser loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);
}