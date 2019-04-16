/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afriquecode.service;

import com.afriquecode.entities.AppRole;
import com.afriquecode.entities.AppUser;

/**
 *
 * @author sglo
 */
public interface AccountService {
    
    public AppUser saveUser(String username, String password, String confirmedPassword);
    
    public AppRole save(AppRole role);
    
    public AppUser loadUserByUsername(String usename);
    
    public void addRoleToUser(String username, String roleName);
    
}
