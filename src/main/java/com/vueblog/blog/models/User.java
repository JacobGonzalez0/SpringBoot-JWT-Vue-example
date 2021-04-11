package com.vueblog.blog.models;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


@Entity
@Table(name = "users")
public class User implements UserDetails{
    
    /**
     *
     */
    private static final long serialVersionUID = -7946039417513536111L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is Required")
    @Size(min = 5, max = 16, message = "Username must be between 5-16 characters")
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotBlank(message = "Email is Required")
    @Email
    private String email;

    @NotBlank(message = "Password is Required")
    @Size(min = 5, message = "Password must be between 5-16 characters")
    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany
    private List<AuthGroup> authGroups;

    public User(Long id, String username, String email, String phone) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<AuthGroup> getAuthGroups() {
        return this.authGroups;
    }

    public void setAuthGroups(List<AuthGroup> authGroups) {
        this.authGroups = authGroups;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(null == authGroups){
            return Collections.emptySet();
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        authGroups.forEach(group->{
            //grabs each group and puts them in the hashset to return
            grantedAuthorities.add(
                new SimpleGrantedAuthority(group.getAuthGroup())
            );
        });
        return grantedAuthorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }
    

}

