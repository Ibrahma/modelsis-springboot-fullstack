package com.example.modelsisspringbootfullstack.services;
import com.example.modelsisspringbootfullstack.dao.AppRoleRepository;
import com.example.modelsisspringbootfullstack.dao.AppUserRepository;
import com.example.modelsisspringbootfullstack.dto.AppUserDto;
import com.example.modelsisspringbootfullstack.entities.AppRole;
import com.example.modelsisspringbootfullstack.entities.AppUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public AppUser saveUser(AppUserDto appUserDto) {
        AppUser appUser=new AppUser();
        appUser.setUsername(appUserDto.getUsername());
        appUser.setPassword(bCryptPasswordEncoder.encode(appUserDto.getPassword()));
        appUserRepository.saveAndFlush(appUser);
        addRoleToUser(appUser.getUsername(),"USER");
        return appUser;
    }

    @Override
    public AppRole save(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        AppUser appUser=appUserRepository.findByUsername(username);
        AppRole appRole=appRoleRepository.findByRoleName(rolename);
        appUser.getRoles().add(appRole);
    }
}