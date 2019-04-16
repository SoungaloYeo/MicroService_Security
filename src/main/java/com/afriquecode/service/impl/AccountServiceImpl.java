/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afriquecode.service.impl;

import com.afriquecode.entities.AppRole;
import com.afriquecode.entities.AppUser;
import com.afriquecode.repository.AppRoleRepository;
import com.afriquecode.repository.AppUserRepository;
import com.afriquecode.service.AccountService;
import javax.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpl(AppUserRepository appUserRepository, 
                                                        AppRoleRepository appRoleRepository, 
                                                        BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public AppUser saveUser(String username, String password, String confirmedPassword) {
            AppUser user = appUserRepository.findByUsername(username);
            if(user != null) throw new RuntimeException("User already exists");
            if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
            AppUser appUser = new AppUser();
            appUser.setUsername(username);
            appUser.setActived(true);
            appUser.setPassword(bCryptPasswordEncoder.encode(password));
            appUserRepository.save(appUser);
            addRoleToUser(username, "USER");
            return appUser;
    }

    @Override
    public AppRole save(AppRole appRole) {
            return appRoleRepository.save(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String usename) {
            return appUserRepository.findByUsername(usename);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
            AppUser appUser= appUserRepository.findByUsername(username);
            AppRole appRole = appRoleRepository.findByRoleName(roleName);
            appUser.getRoles().add(appRole);
    }
    
}
