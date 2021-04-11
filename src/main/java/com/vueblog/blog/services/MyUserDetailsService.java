package com.vueblog.blog.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new User("foo", "$2y$11$G9EA6yb9/TLGXXeXKWbJtOiZ8BP09h1Xndr5pAQ20FUhXSb/yyAJq",
                new ArrayList<>());
    }
}