/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afriquecode.repository;

import com.afriquecode.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author sglo
 */
@RepositoryRestResource
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    public AppUser findByUsername(String username);
}
