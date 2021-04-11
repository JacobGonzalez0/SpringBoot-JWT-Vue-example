package com.vueblog.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vueblog.blog.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = this.userRepository.findByUsername(username);
        //if we cant find our user we throw this
        if(null==user){
            throw new UsernameNotFoundException("cannot find username: " + username);
        }
        //now we check the auth groups 
        return user;
    }
}