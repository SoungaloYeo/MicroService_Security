/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afriquecode.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author sglo
 */
@Entity
@Data @ToString
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
//    private String nom;
//    private String prenom;
    private boolean actived;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles = new ArrayList<>();
    
}
