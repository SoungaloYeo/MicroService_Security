/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afriquecode.repository;

import com.afriquecode.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author sglo
 */
@RepositoryRestResource
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {

    public AppRole findByRoleName(String roleName);
}
