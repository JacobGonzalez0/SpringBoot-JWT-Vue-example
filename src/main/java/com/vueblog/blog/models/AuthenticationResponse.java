package com.vueblog.blog.models;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6283584364633913183L;
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
