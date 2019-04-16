/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afriquecode.web;

import com.afriquecode.entities.AppUser;
import com.afriquecode.service.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yéo <yeo at sygno.tech>
 */
@RestController
public class UserController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public AppUser register(@RequestBody UserForm userForm){
        return accountService.saveUser(
                userForm.getUsername(), 
                userForm.getPassword(),
                userForm.getConfirmedPassword());
    }
}

@Data
class UserForm {
    private String username;
    private String password;
    private String confirmedPassword;
}
